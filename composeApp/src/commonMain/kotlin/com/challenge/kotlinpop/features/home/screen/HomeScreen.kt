package com.challenge.kotlinpop.features.home.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import app.cash.paging.compose.collectAsLazyPagingItems
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ZERO
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.modifier.defaultScreenColumnModifier
import br.com.challenge.kotlinpop.ds.components.about.AboutComponent
import br.com.challenge.kotlinpop.ds.components.chip.CustomChip
import br.com.challenge.kotlinpop.ds.components.item.GitHubRepositoryItem
import br.com.challenge.kotlinpop.ds.components.loading.Loading
import br.com.challenge.kotlinpop.ds.components.top.KotlinPopTopBar
import com.challenge.kotlinpop.domain.mapping.toModel
import com.challenge.kotlinpop.features.home.action.HomeAction
import com.challenge.kotlinpop.features.home.state.HomeState
import com.challenge.kotlinpop.features.home.viewmodel.HomeViewModel
import com.challenge.kotlinpop.platform.Platform
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(navigateToDetails: () -> Unit) {

    // ViewModel and state retrieval for the home process
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LifecycleEventEffect(event = Lifecycle.Event.ON_START) {
        viewModel.submitAction(HomeAction.RequestData)
    }

    HomeContent(
        state = state,
        navigateToDetails = navigateToDetails,
        action = viewModel::submitAction
    )
}

@Composable
fun HomeContent(
    state: HomeState,
    action: (HomeAction) -> Unit,
    navigateToDetails: () -> Unit
) {

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

                // Handle various states of the registration process
                when (state) {
                    is HomeState.Idle -> {}
                    is HomeState.OnBackPressed -> {}
                    is HomeState.ShowData -> {
                        val pagedList = state.data.collectAsLazyPagingItems()

                        when {
                            pagedList.loadState.refresh is LoadState.Loading ||
                                    pagedList.loadState.append is LoadState.Loading -> {
                                Loading()
                            }

                            pagedList.loadState.refresh is LoadState.Error ||
                                    pagedList.loadState.append is LoadState.Error ||
                                    pagedList.loadState.prepend is LoadState.Error -> {

                            }

                            else -> {
                                if (pagedList.itemCount == KEY_NUMBER_ZERO) {
                                    Loading()
                                } else {
                                    LazyColumn {
                                        items(pagedList.itemCount) { index ->
                                            pagedList[index]?.let { item ->
                                                GitHubRepositoryItem(
                                                    repositoryName = item.name.orEmpty(),
                                                    description = item.description.orEmpty(),
                                                    username = item.githubRepositoryOwnerDomain?.login.orEmpty(),
                                                    fullName = item.githubRepositoryOwnerDomain?.login.orEmpty(),
                                                    forks = item.forks ?: 0,
                                                    stars = item.score ?: 0.0,
                                                    avatarUrl = item.githubRepositoryOwnerDomain?.avatarUrl.orEmpty(),
                                                    modifier = Modifier.padding(8.dp)
                                                )
                                            }
                                        }

                                        if (pagedList.loadState.append == LoadState.Loading) {
                                            item {
                                                Loading()
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}