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

/**
 * ViewModel responsible for managing the state and actions of the Details screen.
 * This ViewModel interacts with the `GetDetailsUseCase` to fetch GitHub Pull Requests
 * and handles user actions such as requesting data and handling back navigation.
 *
 * The state of the UI is represented by a `StateFlow`, and actions are processed via a `MutableSharedFlow`.
 */
class DetailsViewModel(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Flow to collect and process user actions asynchronously
    private val pendingActions = MutableSharedFlow<DetailsAction>()

    // Mutable state to manage the UI state, exposed as an immutable StateFlow
    private var _state: MutableStateFlow<DetailsState> =
        MutableStateFlow(DetailsState.Idle)
    val state: StateFlow<DetailsState> = _state

    // Current repository creator and repo name, extracted from the navigation arguments
    private var currentCreator = savedStateHandle.toRoute<HomeRoutes.Details>().creator
    private val currentRepo = savedStateHandle.toRoute<HomeRoutes.Details>().repo

    init {
        // Start processing actions as soon as the ViewModel is initialized
        handleActions()
    }

    /**
     * Initiates a request to fetch GitHub Pull Requests for the current repository.
     * Updates the state to Loading and calls the use case to retrieve data.
     */
    private fun requestGithubPullRequests() {
        viewModelScope.launch {
            DetailsState.Loading.updateState()
            getGithubPullRequests()
        }
    }

    /**
     * Fetches GitHub Pull Requests using the `GetDetailsUseCase`.
     * Updates the state based on the result:
     * - Shows data if successful and not empty.
     * - Displays an error message if the result is empty or there is an error.
     */
    private fun getGithubPullRequests() {
        viewModelScope.launch {
            getDetailsUseCase.getGithubPullRequests(
                creator = currentCreator,
                repo = currentRepo
            ).singleOrThrow(
                success = { data ->
                    if (data.isEmpty()) {
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

    /**
     * Collects actions emitted to the `pendingActions` flow and processes them.
     * Each action triggers a specific behavior, such as fetching data or handling back navigation.
     */
    private fun handleActions() = viewModelScope.launch {
        pendingActions.collect { action ->
            when (action) {
                is DetailsAction.Idle -> {} // No action required for Idle state
                is DetailsAction.RequestOnBackPressed -> requestOnBackPressed()
                is DetailsAction.RequestData -> requestGithubPullRequests()
            }
        }
    }

    /**
     * Handles the back navigation action by updating the state to `OnBackPressed`.
     */
    private fun requestOnBackPressed() {
        viewModelScope.launch {
            DetailsState.OnBackPressed.updateState()
        }
    }

    /**
     * Submits an action to the `pendingActions` flow to be processed.
     * @param action The action to be processed.
     */
    fun submitAction(action: DetailsAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    /**
     * Updates the current state of the ViewModel by applying the new `DetailsState` value.
     */
    private fun DetailsState.updateState() = _state.update { this }
}