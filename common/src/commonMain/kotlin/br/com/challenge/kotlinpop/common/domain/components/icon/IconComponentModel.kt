package br.com.challenge.kotlinpop.common.domain.components.icon

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class IconComponentModel(
    val painter: Painter? = null,
    val imageVector: ImageVector? = null,
    val contentDescription: String? = null,
    val tint: Color = Color.Black,
    val modifier: Modifier = Modifier
)