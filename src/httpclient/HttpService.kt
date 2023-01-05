package com.neci.httpclient

import io.ktor.client.*

interface HttpService {
    fun getClient(): HttpClient
}