package com.neci

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import com.neci.di.applicationModule
import com.neci.errors.GenericServerError
import com.neci.features.authentication.di.authenticationModule
import com.neci.features.device.di.deviceDataModule
import com.neci.jwt.JwtManager
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.koin.java.KoinJavaComponent.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger
import org.slf4j.event.Level
import java.text.DateFormat
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.cors.routing.*

//fun main(args: Array<String>): Unit = io.ktor.server.tomcat.EngineMain.main(args)
fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

@Suppress("unused") // Referenced in application.conf
fun Application.module(testing: Boolean = false) {
    install(CORS){
        anyHost()
    }
    install(Koin) {
        SLF4JLogger()
        modules(applicationModule, authenticationModule, deviceDataModule)
    }

    val jwtManager: JwtManager by inject(JwtManager::class.java)

    install(Authentication) {
        jwt {
            verifier(jwtManager.getVerifier())
            validate {
                UserIdPrincipal(it.payload.getClaim("email").asString())
            }
        }
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
            registerModule(JavaTimeModule())
            dateFormat = DateFormat.getDateInstance()
        }
    }

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.response.status(HttpStatusCode.InternalServerError)
            call.respond(GenericServerError(500, cause.message.toString()))
            throw cause
        }
        exception<MissingKotlinParameterException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest)
            throw cause
        }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    routes()
}