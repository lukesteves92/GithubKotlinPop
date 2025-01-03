package com.challenge.kotlinpop.features.home.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.cash.paging.LoadStateError
import app.cash.paging.LoadStateLoading
import app.cash.paging.LoadStateNotLoading
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import br.com.challenge.kotlinpop.common.extensions.string.getTotalRepositories
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ONE
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.modifier.defaultScreenColumnModifier
import br.com.challenge.kotlinpop.ds.components.about.AboutComponent
import br.com.challenge.kotlinpop.ds.components.chip.CustomChip
import br.com.challenge.kotlinpop.ds.components.error.ApiErrorScreen
import br.com.challenge.kotlinpop.ds.components.item.repo.GithubRepositoryItem
import br.com.challenge.kotlinpop.ds.components.loading.Loading
import br.com.challenge.kotlinpop.ds.components.top.KotlinPopTopBar
import com.challenge.kotlinpop.domain.mapping.toModel
import com.challenge.kotlinpop.features.home.action.HomeAction
import com.challenge.kotlinpop.features.home.state.HomeState
import com.challenge.kotlinpop.features.home.viewmodel.HomeViewModel
import com.challenge.kotlinpop.platform.Platform
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(navigateToDetails: (String, String) -> Unit) {

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
    navigateToDetails: (String, String) -> Unit
) {

    var showAboutContent by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            KotlinPopTopBar(
                showAboutContent = showAboutContent,
                onClickAbout = { condition -> showAboutContent = condition }
            )
        },
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

                // Handle various states of the registration process
                when (state) {
                    is HomeState.Idle -> {}
                    is HomeState.OnBackPressed -> {}
                    is HomeState.NavigateToDetails -> {
                        action(HomeAction.Idle)
                        navigateToDetails(state.creator, state.repo)
                    }

                    is HomeState.ShowData -> {
                        val pagedList = state.data.collectAsLazyPagingItems()
                        PagingColumn(
                            data = pagedList,
                            action = action,
                            content = { item ->
                                GithubRepositoryItem(
                                    model = item,
                                    onClick = { creator, repo ->
                                        action(
                                            HomeAction.RequestNavigateToDetails(
                                                creator = creator, repo = repo
                                            )
                                        )
                                    }
                                )
                            })
                    }
                }
            }
        }
    )
}

@Composable
fun <T : Any> PagingColumn(
    data: LazyPagingItems<T>,
    content: @Composable (T) -> Unit,
    action: (HomeAction) -> Unit
) {

    CustomChip(data.itemCount.getTotalRepositories())

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(data.itemCount) { index ->
            val item = data[index]
            item?.let { content(it) }
        }
        data.loadState.apply {
            when {
                refresh is LoadStateNotLoading && data.itemCount < KEY_NUMBER_ONE -> {
                    item {
                        ApiErrorScreen(
                            onClick = { action(HomeAction.RequestData) }
                        )
                    }
                }

                refresh is LoadStateLoading -> {
                    item {
                        Loading()
                    }
                }

                append is LoadStateLoading -> {
                    item {
                        Loading()
                    }
                }

                refresh is LoadStateError -> {
                    item {
                        ApiErrorScreen(
                            onClick = { action(HomeAction.RequestData) }
                        )
                    }
                }

                append is LoadStateError -> {
                    item {
                        ApiErrorScreen(
                            onClick = { action(HomeAction.RequestData) }
                        )
                    }
                }
            }
        }
    }
}