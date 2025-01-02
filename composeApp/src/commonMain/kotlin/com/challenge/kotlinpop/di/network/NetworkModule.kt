package com.challenge.kotlinpop.di.network

import br.com.challenge.kotlinpop.core.wrapper.main.RequestWrapper
import br.com.challenge.kotlinpop.core.wrapper.impl.RequestWrapperImpl
import com.challenge.kotlinpop.env.EnvironmentConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {

    // Ktor Client
    single<HttpClient> {
        HttpClient {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = EnvironmentConfig.baseUrl
                    contentType(ContentType.Application.Json)
                }
            }
        }
    }

    // Request Wrapper
    factoryOf(::RequestWrapperImpl).bind(RequestWrapper::class)
}