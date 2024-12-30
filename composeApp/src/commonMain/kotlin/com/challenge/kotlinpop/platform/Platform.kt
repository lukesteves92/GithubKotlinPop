package com.challenge.kotlinpop.platform

expect class Platform(){
    val isDebugVersion: Boolean
    val appVersion: String
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()
}