package br.com.challenge.kotlinpop.ds.components.item.pr

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import br.com.challenge.kotlinpop.common.domain.model.pr.main.GithubPRResultItemDomain
import br.com.challenge.kotlinpop.common.util.constants.Constants.Github.KEY_GITHUB_DEFAULT_URL
import br.com.challenge.kotlinpop.common.util.constants.Constants.Image.KEY_IMAGE_DEFAULT_URL
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_TWO
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderRadiusSm
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderRadiusXs
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderWidthXs
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimen4XSLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenSmallMedium
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import br.com.challenge.kotlinpop.ds.ui.typography.KotlinPopTypography
import com.final_class.webview_multiplatform_mobile.webview.WebViewPlatform
import com.final_class.webview_multiplatform_mobile.webview.controller.rememberWebViewController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage

@Composable
fun GithubPRItem(
    model: GithubPRResultItemDomain,
    modifier: Modifier = Modifier
) {

    val webViewController by rememberWebViewController()

    WebViewPlatform(webViewController = webViewController)

    Card(
        modifier = modifier
            .clickable { webViewController.open(url = model.htmlUrl ?: KEY_GITHUB_DEFAULT_URL) }
            .padding(kotlinPopDimenSmallMedium)
            .fillMaxWidth(),
        shape = RoundedCornerShape(kotlinPopBorderRadiusSm),
        colors = CardDefaults.cardColors(
            containerColor = KotlinPopTheme.colorScheme.screen.background
        ),
        elevation = CardDefaults.cardElevation(kotlinPopBorderRadiusXs)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(kotlinPopDimenLarge)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = kotlinPopDimenSmallMedium)
                ) {

                    Text(
                        text = model.title.orEmpty(),
                        style = KotlinPopTypography.headingXS,
                        color = KotlinPopTheme.colorScheme.text.primary
                    )

                    Text(
                        text = model.body.orEmpty(),
                        style = KotlinPopTypography.paragraphMD,
                        color = KotlinPopTheme.colorScheme.text.primary,
                        maxLines = KEY_NUMBER_TWO,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(kotlinPopDimenSmallMedium))

                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CoilImage(
                        modifier = Modifier
                            .size(kotlinPopDimen4XSLarge)
                            .clip(CircleShape),
                        imageModel = { model.user?.avatarUrl ?: KEY_IMAGE_DEFAULT_URL },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    )

                    Text(
                        text = model.user?.login.orEmpty(),
                        style = KotlinPopTypography.headingXS,
                        color = KotlinPopTheme.colorScheme.text.primary
                    )
                }
            }
        }
    }

    HorizontalDivider(
        color = Color.Black,
        thickness = kotlinPopBorderWidthXs,
        modifier = Modifier.padding(kotlinPopDimenSmallMedium)
    )
}