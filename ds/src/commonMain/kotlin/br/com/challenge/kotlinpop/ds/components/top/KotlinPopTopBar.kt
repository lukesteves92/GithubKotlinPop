package br.com.challenge.kotlinpop.ds.components.top

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import br.com.challenge.kotlinpop.common.domain.IconComponentModel
import br.com.challenge.kotlinpop.common.domain.ImageComponentModel
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimen2XLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimen4XsLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenSmallMedium
import br.com.challenge.kotlinpop.ds.components.icon.IconComponent
import br.com.challenge.kotlinpop.ds.components.image.ImageComponent
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import br.com.challenge.kotlinpop.ds.ui.typography.KotlinPopTypography
import br.com.challenge.kotlinpop.ds.ui.typography.LTAsusFontFamily
import githubkotlinpop.ds.generated.resources.Res
import githubkotlinpop.ds.generated.resources.kotlin_pop_ic_arrow_left
import githubkotlinpop.ds.generated.resources.kotlin_pop_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun KotlinPopTopBar(
    modifier: Modifier = Modifier,
    isNavigation: Boolean = false,
    navigationIcon: Painter = painterResource(Res.drawable.kotlin_pop_ic_arrow_left),
    navigationText: String = EMPTY_STRING_DEFAULT,
    onClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = kotlinPopDimenLarge)
            .height(kotlinPopDimen4XsLarge)
    ) {
        val navigationIconModel = IconComponentModel(
            painter = navigationIcon
        )

        val logoImageModel = ImageComponentModel(
            painter = painterResource(Res.drawable.kotlin_pop_logo),
            height = kotlinPopDimen4XsLarge,
            modifier = Modifier.align(Alignment.Center)
        )

        if (isNavigation) {
            Row(
                modifier = Modifier
                    .padding(start = kotlinPopDimenLarge)
                    .clickable(
                        onClick = onClick,
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    )
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconComponent(model = navigationIconModel)

                Text(
                    modifier = Modifier.padding(start = kotlinPopDimenSmallMedium),
                    fontFamily = LTAsusFontFamily(),
                    text = navigationText,
                    color = KotlinPopTheme.colorScheme.text.color,
                    style = KotlinPopTypography.subtitleSM
                )
            }
        }

        ImageComponent(model = logoImageModel)
    }
}