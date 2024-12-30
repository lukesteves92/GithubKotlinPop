package br.com.challenge.kotlinpop.ds.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.challenge.kotlinpop.common.domain.ImageComponentModel
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenNone

@Composable
fun ImageComponent(model: ImageComponentModel) {
    val size = model.size
    val padding = model.padding
    val paddingStart = model.paddingStart
    val paddingEnd = model.paddingEnd
    val width = model.width
    val height = model.height

    Image(
        painter = model.painter,
        contentDescription = model.contentDescription,
        modifier = model.modifier
            .then(if (padding != null) Modifier.padding(padding) else Modifier)
            .then(
                if (paddingStart != null || paddingEnd != null)
                    Modifier.padding(
                        start = paddingStart ?: kotlinPopDimenNone,
                        end = paddingEnd ?: kotlinPopDimenNone
                    )
                else Modifier
            )
            .then(if (size != null) Modifier.size(size) else Modifier)
            .then(if (width != null && height != null) Modifier.size(width, height) else Modifier)
    )
}