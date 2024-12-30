package br.com.challenge.kotlinpop.common.util.modifier

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.helloDimenNone

@Composable
fun Modifier.defaultScreenColumnModifier(
    paddingValues: PaddingValues = PaddingValues(helloDimenNone),
    horizontalPadding: Dp = helloDimenNone,
    verticalPadding: Dp = helloDimenNone
): Modifier {
    return this
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(paddingValues)
        .padding(horizontal = horizontalPadding, vertical = verticalPadding)
}