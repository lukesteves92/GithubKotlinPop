package com.challenge.kotlinpop.env

expect object EnvironmentConfig {
    val isDebugVersion: Boolean
    val baseUrl: String
    val environmentSuffix: String
}