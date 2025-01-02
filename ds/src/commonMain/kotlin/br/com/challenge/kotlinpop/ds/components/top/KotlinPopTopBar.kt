package br.com.challenge.kotlinpop.ds.components.top

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import br.com.challenge.kotlinpop.common.domain.components.icon.IconComponentModel
import br.com.challenge.kotlinpop.common.domain.components.image.ImageComponentModel
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderWidthLg
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderWidthSm
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimen4XsLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenSmallMedium
import br.com.challenge.kotlinpop.ds.components.icon.IconComponent
import br.com.challenge.kotlinpop.ds.components.image.ImageComponent
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import br.com.challenge.kotlinpop.ds.ui.typography.KotlinPopTypography
import br.com.challenge.kotlinpop.ds.ui.typography.LTAsusFontFamily
import githubkotlinpop.ds.generated.resources.Res
import githubkotlinpop.ds.generated.resources.kotlin_pop_bt_about_txt
import githubkotlinpop.ds.generated.resources.kotlin_pop_ic_arrow_left
import githubkotlinpop.ds.generated.resources.kotlin_pop_logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun KotlinPopTopBar(
    modifier: Modifier = Modifier,
    isNavigation: Boolean = false,
    showAboutContent: Boolean,
    navigationIcon: Painter = painterResource(Res.drawable.kotlin_pop_ic_arrow_left),
    navigationText: String = EMPTY_STRING_DEFAULT,
    onClickAbout: (Boolean) -> Unit = {},
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
                    color = KotlinPopTheme.colorScheme.text.primary,
                    style = KotlinPopTypography.subtitleSM
                )
            }
        }

        ImageComponent(model = logoImageModel)

        Row(
            modifier = Modifier
                .padding(start = kotlinPopDimenLarge, end = kotlinPopDimenLarge)
                .align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = KotlinPopTheme.colorScheme.button.background,
                    contentColor = KotlinPopTheme.colorScheme.text.primary
                ),
                onClick = { onClickAbout.invoke(!showAboutContent)  },
                modifier = Modifier.border(
                    width = kotlinPopBorderWidthSm,
                    color = KotlinPopTheme.colorScheme.button.border,
                    shape = RoundedCornerShape(kotlinPopBorderWidthLg)
                )
            ) {
                Text(stringResource(Res.string.kotlin_pop_bt_about_txt))
            }
        }
    }
}
