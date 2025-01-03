package com.challenge.kotlinpop.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.kotlinpop.domain.usecase.home.GetHomeUseCase
import com.challenge.kotlinpop.features.home.action.HomeAction
import com.challenge.kotlinpop.features.home.state.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for managing the state and actions of the Home screen.
 * This ViewModel interacts with the `GetHomeUseCase` to fetch GitHub repositories
 * and handles user actions such as navigating to details or fetching data.
 *
 * The state of the UI is represented by a `StateFlow`, and actions are processed via a `MutableSharedFlow`.
 */
class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {

    // Flow to collect and process user actions asynchronously
    private val pendingActions = MutableSharedFlow<HomeAction>()

    // Mutable state to manage the UI state, exposed as an immutable StateFlow
    private var _state: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.Idle)
    val state: StateFlow<HomeState> = _state

    init {
        // Start processing actions as soon as the ViewModel is initialized
        handleActions()
    }

    /**
     * Fetches GitHub repositories using the `GetHomeUseCase`.
     * Updates the state with the fetched data to be displayed on the Home screen.
     */
    private fun getGithubRepos() {
        viewModelScope.launch {
            HomeState.ShowData(
                data = getHomeUseCase.getGithubRepos()
            ).updateState()
        }
    }

    /**
     * Triggers navigation to the Details screen by updating the state with the necessary parameters.
     * @param creator The creator/owner of the repository.
     * @param repo The name of the repository.
     */
    private fun requestNavigateToDetails(creator: String, repo: String) {
        viewModelScope.launch {
            HomeState.NavigateToDetails(
                creator = creator,
                repo = repo
            ).updateState()
        }
    }

    /**
     * Collects actions emitted to the `pendingActions` flow and processes them.
     * Each action triggers a specific behavior, such as fetching data or navigating to details.
     */
    private fun handleActions() = viewModelScope.launch {
        pendingActions.collect { action ->
            when (action) {
                is HomeAction.Idle -> requestIdleState()
                is HomeAction.RequestData -> getGithubRepos()
                is HomeAction.RequestNavigateToDetails -> requestNavigateToDetails(
                    creator = action.creator,
                    repo = action.repo
                )
            }
        }
    }

    /**
     * Submits an action to the `pendingActions` flow to be processed.
     * @param action The action to be processed.
     */
    fun submitAction(action: HomeAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    /**
     * Sets the state to idle, typically when no specific actions are triggered.
     */
    private fun requestIdleState() {
        viewModelScope.launch {
            HomeState.Idle.updateState()
        }
    }

    /**
     * Updates the current state of the ViewModel by applying the new `HomeState` value.
     */
    private fun HomeState.updateState() = _state.update { this }
}