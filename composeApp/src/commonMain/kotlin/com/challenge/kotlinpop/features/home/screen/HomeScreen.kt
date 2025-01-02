package com.challenge.kotlinpop.features.home.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.modifier.defaultScreenColumnModifier
import br.com.challenge.kotlinpop.ds.components.about.AboutComponent
import br.com.challenge.kotlinpop.ds.components.chip.CustomChip
import br.com.challenge.kotlinpop.ds.components.item.GitHubRepositoryItem
import br.com.challenge.kotlinpop.ds.components.top.KotlinPopTopBar
import com.challenge.kotlinpop.domain.mapping.toModel
import com.challenge.kotlinpop.platform.Platform

@Composable
fun HomeScreen(navigateToDetails: () -> Unit) {
    HomeContent(navigateToDetails = navigateToDetails)
}

@Composable
fun HomeContent(navigateToDetails: () -> Unit) {

    var showAboutContent by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = { KotlinPopTopBar(
            showAboutContent = showAboutContent,
            onClickAbout = { condition -> showAboutContent = condition }
        ) },
        bottomBar = {},
        floatingActionButton = {},
        content = { paddingValues ->
            Column(
                modifier = Modifier.defaultScreenColumnModifier(
                    paddingValues = paddingValues,
                    horizontalPadding = kotlinPopDimenLarge
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(showAboutContent) {
                    AboutComponent(items = Platform().toModel())
                }

                CustomChip("Total: 3000")

                GitHubRepositoryItem(
                    repositoryName = "Nome Repositório",
                    description = "Descrição do repositório lorem ipsum dolor sit amet...",
                    username = "username",
                    fullName = "Nome Sobrenome",
                    forks = 640,
                    stars = 98,
                    avatarUrl = "https://avatars.githubusercontent.com/u/123456?v=4",
                    modifier = Modifier.padding(8.dp)
                )

                Button(onClick = { navigateToDetails.invoke() }) {
                    Text("Navigate to Details!")
                }
            }
        }
    )
}