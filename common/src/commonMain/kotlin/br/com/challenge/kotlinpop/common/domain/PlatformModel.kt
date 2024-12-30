package br.com.challenge.kotlinpop.common.domain

data class PlatformModel(
    val isDebugVersion: Boolean,
    val appVersion: String,
    val osName: String,
    val osVersion: String,
    val deviceModel: String,
    val density: Int
)