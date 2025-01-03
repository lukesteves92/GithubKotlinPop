package br.com.challenge.kotlinpop.ds.components.error

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import br.com.challenge.kotlinpop.common.domain.components.image.ImageComponentModel
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_API_ERROR_MESSAGE_DEFAULT
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderWidthLg
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderWidthSm
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimen4XSLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimen4XsLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenSmallMedium
import br.com.challenge.kotlinpop.ds.components.image.ImageComponent
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import br.com.challenge.kotlinpop.ds.ui.typography.KotlinPopTypography
import githubkotlinpop.ds.generated.resources.Res
import githubkotlinpop.ds.generated.resources.kotlin_pop_bt_re_try_txt
import githubkotlinpop.ds.generated.resources.kotlin_pop_ic_error
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ApiErrorScreen(
    message: String? = null,
    onClick: () -> Unit
) {

    val logoImageErrorModel = ImageComponentModel(
        painter = painterResource(Res.drawable.kotlin_pop_ic_error),
        height = kotlinPopDimen4XsLarge,
        modifier = Modifier.wrapContentSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KotlinPopTheme.colorScheme.screen.background)
            .padding(horizontal = kotlinPopDimenLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ImageComponent(model = logoImageErrorModel)

        Spacer(modifier = Modifier.height(kotlinPopDimenLarge))

        Text(
            text = message ?: KEY_API_ERROR_MESSAGE_DEFAULT,
            modifier = Modifier
                .padding(kotlinPopDimenSmallMedium),
            style = KotlinPopTypography.headingXS,
            color = KotlinPopTheme.colorScheme.text.primary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(kotlinPopDimen4XSLarge))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = KotlinPopTheme.colorScheme.button.background,
                contentColor = KotlinPopTheme.colorScheme.text.primary
            ),
            onClick = onClick,
            modifier = Modifier.border(
                width = kotlinPopBorderWidthSm,
                color = KotlinPopTheme.colorScheme.button.border,
                shape = RoundedCornerShape(kotlinPopBorderWidthLg)
            )
        ) {
            Text(stringResource(Res.string.kotlin_pop_bt_re_try_txt))
        }
    }
}