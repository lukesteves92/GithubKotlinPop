package com.challenge.kotlinpop.main

import androidx.compose.ui.window.ComposeUIViewController
import com.challenge.kotlinpop.di.main.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }