package com.challenge.kotlinpop.env

import platform.Foundation.NSProcessInfo
import platform.Foundation.NSBundle

actual object EnvironmentConfig {
    actual val baseUrl: String
        get() = NSBundle.mainBundle.objectForInfoDictionaryKey("BASE_URL").toString()

    actual val environmentSuffix: String
        get() = (NSProcessInfo.processInfo.environment["ENVIRONMENT_SUFFIX"] ?: ".prod").toString()

    actual val isDebugVersion: Boolean
        get() = (NSProcessInfo.processInfo.environment["ENVIRONMENT_SUFFIX"]).toString() == ".dev"
}