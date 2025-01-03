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

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {

    private val pendingActions = MutableSharedFlow<HomeAction>()
    private var _state: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.Idle)
    val state: StateFlow<HomeState> = _state

    init {
        handleActions()
    }

    private fun getGithubRepos() {
        viewModelScope.launch {
            HomeState.ShowData(
                data = getHomeUseCase.getGithubRepos()
            ).updateState()
        }
    }

    private fun requestNavigateToDetails(creator: String, repo: String) {
        viewModelScope.launch {
            HomeState.NavigateToDetails(
                creator = creator,
                repo = repo
            ).updateState()
        }
    }

    // Handle pending actions and triggers appropriate behavior based on the action type
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

    // Submits an action by emitting it to the shared flow of pending actions
    fun submitAction(action: HomeAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    // Sets the state to idle, usually when no specific actions are triggered
    private fun requestIdleState() {
        viewModelScope.launch {
            HomeState.Idle.updateState()
        }
    }

    // Extension function to update the state with the new home state value
    private fun HomeState.updateState() = _state.update { this }
}