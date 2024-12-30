package com.challenge.kotlinpop.main

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import com.challenge.kotlinpop.navigation.HomeNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    KotlinPopTheme {
        Scaffold(
            modifier = Modifier
                .imePadding(),
            containerColor = KotlinPopTheme.colorScheme.screen.background,
            content = { paddingValues ->
                HomeNavHost(
                    modifier = Modifier
                        .padding(paddingValues),
                    navHostController = rememberNavController()
                )
            }
        )
    }
}