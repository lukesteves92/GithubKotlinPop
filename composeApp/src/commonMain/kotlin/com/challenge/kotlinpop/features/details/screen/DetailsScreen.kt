package com.challenge.kotlinpop.features.details.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import br.com.challenge.kotlinpop.common.extensions.string.getNameRepository
import br.com.challenge.kotlinpop.common.extensions.string.getTotalRepositories
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ZERO
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_REPO
import br.com.challenge.kotlinpop.common.util.dimens.Dimens.kotlinPopDimenLarge
import br.com.challenge.kotlinpop.common.util.modifier.defaultScreenColumnModifier
import br.com.challenge.kotlinpop.ds.components.about.AboutComponent
import br.com.challenge.kotlinpop.ds.components.chip.CustomChip
import br.com.challenge.kotlinpop.ds.components.error.ApiErrorScreen
import br.com.challenge.kotlinpop.ds.components.item.pr.GithubPRItem
import br.com.challenge.kotlinpop.ds.components.loading.Loading
import br.com.challenge.kotlinpop.ds.components.top.KotlinPopTopBar
import com.challenge.kotlinpop.domain.mapping.toModel
import com.challenge.kotlinpop.features.details.action.DetailsAction
import com.challenge.kotlinpop.features.details.state.DetailsState
import com.challenge.kotlinpop.features.details.viewmodel.DetailsViewModel
import com.challenge.kotlinpop.platform.Platform
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailsScreen(onBackPressed: () -> Unit) {

    // ViewModel and state retrieval for the home process
    val viewModel = koinViewModel<DetailsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LifecycleEventEffect(event = Lifecycle.Event.ON_START) {
        viewModel.submitAction(DetailsAction.RequestData)
    }

    DetailsContent(
        state = state,
        action = viewModel::submitAction,
        onBackPressed = onBackPressed
    )
}

@Composable
fun DetailsContent(
    state: DetailsState,
    action: (DetailsAction) -> Unit,
    onBackPressed: () -> Unit
) {

    var showAboutContent by remember { mutableStateOf(false) }
    var showTotalPullRequests by remember { mutableStateOf(KEY_NUMBER_ZERO) }
    var showRepoName by remember { mutableStateOf(EMPTY_STRING_REPO) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = { KotlinPopTopBar(
            showAboutContent = showAboutContent,
            onClickAbout = { condition -> showAboutContent = condition },
            isNavigation = true,
            onClick = { action(DetailsAction.RequestOnBackPressed) }
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

                Row(
                    modifier = Modifier
                        .padding(kotlinPopDimenLarge)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomChip(showTotalPullRequests.getTotalRepositories())
                    CustomChip(showRepoName.getNameRepository())
                }

                // Handle various states of the registration process
                when (state) {
                    is DetailsState.Idle -> {}
                    is DetailsState.Loading -> Loading()
                    is DetailsState.ShowError -> ApiErrorScreen(
                        message = state.message,
                        onClick = { action(DetailsAction.RequestData) }
                    )
                    is DetailsState.OnBackPressed -> {
                        action(DetailsAction.Idle)
                        onBackPressed.invoke()
                    }
                    is DetailsState.ShowData -> {
                        showTotalPullRequests = state.data.size
                        showRepoName = state.repo
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(state.data) { item ->
                                GithubPRItem(model = item)
                            }
                        }
                    }
                }
            }
        }
    )
}