package com.challenge.kotlinpop.platform

import android.content.res.Resources
import android.os.Build
import android.util.Log
import com.challenge.kotlinpop.BuildConfig
import com.challenge.kotlinpop.env.EnvironmentConfig
import kotlin.math.round

actual class Platform {
    actual val isDebugVersion: Boolean
        get() = EnvironmentConfig.isDebugVersion
    actual val appVersion: String
        get() = BuildConfig.VERSION_NAME
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d(
            "Daily News",
            "($osName, $osVersion, $deviceModel, $density)"
        )
    }
}