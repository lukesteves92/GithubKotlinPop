package com.challenge.kotlinpop.platform

import com.challenge.kotlinpop.env.EnvironmentConfig
import platform.Foundation.NSBundle
import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual class Platform {
    actual val appVersion: String
        get() = NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleShortVersionString").toString() + EnvironmentConfig.environmentSuffix
    actual val osName: String
        get() = UIDevice.currentDevice.systemName
    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String
        get() = UIDevice.currentDevice.model
    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()
    actual val isDebugVersion: Boolean
        get() = EnvironmentConfig.isDebugVersion

    actual fun logSystemInfo() {
        NSLog(
            "($osName, $osVersion, $deviceModel, $density)"
        )
    }
}