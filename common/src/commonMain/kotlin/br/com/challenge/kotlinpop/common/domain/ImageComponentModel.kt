package br.com.challenge.kotlinpop.common.domain

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp

data class ImageComponentModel(
    val painter: Painter,
    val contentDescription: String? = null,
    val size: Dp? = null,
    val width: Dp? = null,
    val height: Dp? = null,
    val padding: Dp? = null,
    val paddingStart: Dp? = null,
    val paddingEnd: Dp? = null,
    val modifier: Modifier = Modifier
)