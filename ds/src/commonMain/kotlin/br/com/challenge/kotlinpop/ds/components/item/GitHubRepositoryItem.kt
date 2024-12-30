package br.com.challenge.kotlinpop.ds.components.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import br.com.challenge.kotlinpop.common.domain.IconComponentModel
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderRadiusSm
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderRadiusXs
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderWidthXs
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimen4XSLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenExtraSmall
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenSmallMedium
import br.com.challenge.kotlinpop.ds.components.icon.IconComponent
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import br.com.challenge.kotlinpop.ds.ui.typography.KotlinPopTypography
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import githubkotlinpop.ds.generated.resources.Res
import githubkotlinpop.ds.generated.resources.kotlin_pop_ic_fork
import githubkotlinpop.ds.generated.resources.kotlin_pop_ic_star
import org.jetbrains.compose.resources.painterResource

@Composable
fun GitHubRepositoryItem(
    repositoryName: String,
    description: String,
    username: String,
    fullName: String,
    forks: Int,
    stars: Int,
    avatarUrl: String,
    modifier: Modifier = Modifier
) {

    val forkIconModel = IconComponentModel(
        painter = painterResource(resource = Res.drawable.kotlin_pop_ic_fork)
    )

    val starIconModel = IconComponentModel(
        painter = painterResource(resource = Res.drawable.kotlin_pop_ic_star)
    )

    Card(
        modifier = modifier
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
                        text = repositoryName,
                        style = KotlinPopTypography.headingXS,
                        color = KotlinPopTheme.colorScheme.text.primary
                    )

                    Text(
                        text = description,
                        style = KotlinPopTypography.paragraphMD,
                        color = KotlinPopTheme.colorScheme.text.primary,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(kotlinPopDimenSmallMedium))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconComponent(model = forkIconModel)

                        Spacer(modifier = Modifier.width(kotlinPopDimenExtraSmall))

                        Text(
                            text = forks.toString(),
                            style = KotlinPopTypography.paragraphMD,
                            color = KotlinPopTheme.colorScheme.text.primary,
                        )

                        Spacer(modifier = Modifier.width(kotlinPopDimenLarge))

                        IconComponent(model = starIconModel)

                        Spacer(modifier = Modifier.width(kotlinPopDimenExtraSmall))

                        Text(
                            text = stars.toString(),
                            style = KotlinPopTypography.paragraphMD,
                            color = KotlinPopTheme.colorScheme.text.primary,
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CoilImage(
                        modifier = Modifier
                            .size(kotlinPopDimen4XSLarge)
                            .clip(CircleShape),
                        imageModel = { avatarUrl },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    )

                    Text(
                        text = username,
                        style = KotlinPopTypography.headingXS,
                        color = KotlinPopTheme.colorScheme.text.primary
                    )

                    Text(
                        text = fullName,
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
        modifier = Modifier.padding(horizontal = kotlinPopDimenLarge)
    )
}
