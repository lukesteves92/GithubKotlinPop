package com.challenge.kotlinpop.features.details.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_NO_PULL_REQUESTS_MESSAGE_DEFAULT
import br.com.challenge.kotlinpop.core.navigation.HomeRoutes
import br.com.challenge.kotlinpop.core.singleorthrow.singleOrThrow
import com.challenge.kotlinpop.domain.usecase.details.GetDetailsUseCase
import com.challenge.kotlinpop.features.details.action.DetailsAction
import com.challenge.kotlinpop.features.details.state.DetailsState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val pendingActions = MutableSharedFlow<DetailsAction>()
    private var _state: MutableStateFlow<DetailsState> =
        MutableStateFlow(DetailsState.Idle)
    val state: StateFlow<DetailsState> = _state

    private var currentCreator = savedStateHandle.toRoute<HomeRoutes.Details>().creator
    private val currentRepo = savedStateHandle.toRoute<HomeRoutes.Details>().repo

    init {
        handleActions()
    }

    private fun requestGithubPullRequests() {
        viewModelScope.launch {
            DetailsState.Loading.updateState()
            getGithubPullRequests()
        }
    }

    private fun getGithubPullRequests() {
        viewModelScope.launch {
            getDetailsUseCase.getGithubPullRequests(
                creator = currentCreator,
                repo = currentRepo
            ).singleOrThrow(
                success = { data ->
                    if(data.isEmpty()) {
                        DetailsState.ShowError(message = KEY_NO_PULL_REQUESTS_MESSAGE_DEFAULT).updateState()
                    } else {
                        DetailsState.ShowData(
                            repo = currentRepo,
                            data = data
                        ).updateState()
                    }
                },
                error = { error ->
                    DetailsState.ShowError(message = error.message).updateState()
                }
            )
        }
    }

    // Handle pending actions and triggers appropriate behavior based on the action type
    private fun handleActions() = viewModelScope.launch {
        pendingActions.collect { action ->
            when (action) {
                is DetailsAction.Idle -> {}
                is DetailsAction.RequestOnBackPressed -> requestOnBackPressed()
                is DetailsAction.RequestData -> requestGithubPullRequests()
            }
        }
    }

    private fun requestOnBackPressed() {
        viewModelScope.launch {
            DetailsState.OnBackPressed.updateState()
        }
    }

    // Submits an action by emitting it to the shared flow of pending actions
    fun submitAction(action: DetailsAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    // Extension function to update the state with the new home state value
    private fun DetailsState.updateState() = _state.update { this }

}