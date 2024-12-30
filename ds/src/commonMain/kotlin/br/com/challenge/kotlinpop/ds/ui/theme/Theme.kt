package br.com.challenge.kotlinpop.ds.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import br.com.challenge.kotlinpop.ds.ui.color.KotlinPopColorBaselineText
import br.com.challenge.kotlinpop.ds.ui.color.ScreenBackgroundColor
import br.com.challenge.kotlinpop.ds.ui.scheme.main.MyColorScheme
import br.com.challenge.kotlinpop.ds.ui.scheme.screen.ScreenColorScheme
import br.com.challenge.kotlinpop.ds.ui.scheme.text.TextColorScheme

val DefaultColorScheme = MyColorScheme(
    text = TextColorScheme(
        color = KotlinPopColorBaselineText
    ),
    screen = ScreenColorScheme(
        background = ScreenBackgroundColor
    )
)

private val LocalColorScheme = compositionLocalOf { DefaultColorScheme }

object KotlinPopTheme {
    val colorScheme: MyColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current
}

@Composable
fun KotlinPopTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalColorScheme provides DefaultColorScheme) {
        MaterialTheme(
            content = content
        )
    }
}