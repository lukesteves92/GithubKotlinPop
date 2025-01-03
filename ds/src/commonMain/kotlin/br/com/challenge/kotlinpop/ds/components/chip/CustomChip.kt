package br.com.challenge.kotlinpop.ds.components.chip

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ONE
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderRadiusSm
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopBorderWidthSm
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenSmallMedium
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import br.com.challenge.kotlinpop.ds.ui.typography.KotlinPopTypography

@Composable
fun CustomChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(kotlinPopDimenSmallMedium)
            .wrapContentWidth()
            .wrapContentHeight()
            .border(
                width = kotlinPopBorderWidthSm,
                color = KotlinPopTheme.colorScheme.button.border,
                shape = RoundedCornerShape(kotlinPopBorderRadiusSm)
            ),
        colors = CardDefaults.cardColors(
            containerColor = KotlinPopTheme.colorScheme.screen.background
        ),
        shape = RoundedCornerShape(kotlinPopBorderRadiusSm)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(kotlinPopDimenSmallMedium),
            style = KotlinPopTypography.headingXS,
            color = KotlinPopTheme.colorScheme.text.primary,
            maxLines = KEY_NUMBER_ONE,
            overflow = TextOverflow.Ellipsis
        )
    }
}