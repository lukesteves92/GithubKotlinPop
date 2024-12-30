package com.challenge.kotlinpop.env

import com.challenge.kotlinpop.BuildConfig

actual object EnvironmentConfig {
    actual val isDebugVersion: Boolean
        get() = BuildConfig.DEBUG

    actual val baseUrl: String
        get() = BuildConfig.BASE_URL

    actual val environmentSuffix: String
        get() = if (BuildConfig.DEBUG) ".dev" else ".prod"
}