package br.com.challenge.kotlinpop.ds.components.icon

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import br.com.challenge.kotlinpop.common.domain.components.icon.IconComponentModel

@Composable
fun IconComponent(model: IconComponentModel) {
    val painter = model.painter
    val imageVector = model.imageVector
    val contentDescription = model.contentDescription
    val tint = model.tint
    val modifier = model.modifier

    when {
        painter != null -> Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier
        )
        imageVector != null -> Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier
        )
        else -> throw IllegalArgumentException("Either painter or imageVector must be provided.")
    }
}