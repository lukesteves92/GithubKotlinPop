package com.challenge.kotlinpop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform