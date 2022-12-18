package com.neci.extensions

import io.ktor.server.application.*

fun ApplicationCall.getAuthorizationTokenWithoutBearer(): String? {
    return this.request.headers["Authorization"]?.substring(7)
}