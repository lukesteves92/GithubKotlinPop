package br.com.challenge.kotlinpop.ds.components.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.challenge.kotlinpop.common.domain.platform.PlatformModel
import br.com.challenge.kotlinpop.common.util.constants.Constants.AboutComponent.KEY_KOTLIN_POP_ABOUT_DENSITY
import br.com.challenge.kotlinpop.common.util.constants.Constants.AboutComponent.KEY_KOTLIN_POP_ABOUT_DEVICE
import br.com.challenge.kotlinpop.common.util.constants.Constants.AboutComponent.KEY_KOTLIN_POP_ABOUT_SYSTEM
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenSmallMedium
import br.com.challenge.kotlinpop.ds.ui.theme.KotlinPopTheme
import br.com.challenge.kotlinpop.ds.ui.typography.KotlinPopTypography
import br.com.challenge.kotlinpop.ds.ui.typography.LTAsusFontFamily

@Composable
fun AboutComponent(items: PlatformModel) {
    Column {
        ContentView(items = items)
    }
}

@Composable
private fun ContentView(items: PlatformModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items.makeItems()) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

@Composable
private fun RowView(
    title: String,
    subtitle: String
) {
    Column(modifier = Modifier.padding(kotlinPopDimenSmallMedium)) {
        Text(
            fontFamily = LTAsusFontFamily(),
            text = title,
            style = KotlinPopTypography.headingXS,
            color = KotlinPopTheme.colorScheme.text.primary
        )

        Spacer(modifier = Modifier.height(kotlinPopDimenLarge))

        Text(
            fontFamily = LTAsusFontFamily(),
            text = subtitle,
            style = KotlinPopTypography.headingXS
        )
    }
    HorizontalDivider()
}

private fun PlatformModel.makeItems(): List<Pair<String, String>> {
    return listOf(
        Pair(KEY_KOTLIN_POP_ABOUT_SYSTEM, "${this.osName} ${this.osVersion}"),
        Pair(KEY_KOTLIN_POP_ABOUT_DEVICE, this.deviceModel),
        Pair(KEY_KOTLIN_POP_ABOUT_DENSITY, this.density.toString())
    )
}