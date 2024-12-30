package br.com.challenge.kotlinpop.ds.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import br.com.challenge.kotlinpop.ds.ui.color.ButtonBackgroundColor
import br.com.challenge.kotlinpop.ds.ui.color.ButtonBorderColor
import br.com.challenge.kotlinpop.ds.ui.color.KotlinPopColorBaselineText
import br.com.challenge.kotlinpop.ds.ui.color.KotlinPopColorPrimaryText
import br.com.challenge.kotlinpop.ds.ui.color.ScreenBackgroundColor
import br.com.challenge.kotlinpop.ds.ui.scheme.button.ButtonColorScheme
import br.com.challenge.kotlinpop.ds.ui.scheme.main.MyColorScheme
import br.com.challenge.kotlinpop.ds.ui.scheme.screen.ScreenColorScheme
import br.com.challenge.kotlinpop.ds.ui.scheme.text.TextColorScheme

val DefaultColorScheme = MyColorScheme(
    text = TextColorScheme(
        color = KotlinPopColorBaselineText,
        primary = KotlinPopColorPrimaryText
    ),
    screen = ScreenColorScheme(
        background = ScreenBackgroundColor
    ),
    button = ButtonColorScheme(
        background = ButtonBackgroundColor,
        border = ButtonBorderColor
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