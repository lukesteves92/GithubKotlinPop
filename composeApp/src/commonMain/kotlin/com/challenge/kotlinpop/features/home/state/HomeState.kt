package com.challenge.kotlinpop.features.home.state

import androidx.paging.PagingData
import br.com.challenge.kotlinpop.common.domain.model.repository.item.GithubRepositoryItemDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

sealed interface HomeState {
    data object Idle : HomeState
    data object OnBackPressed: HomeState
    data class NavigateToDetails(val creator: String, val repo: String): HomeState
    data class ShowData(val data: Flow<PagingData<GithubRepositoryItemDomain>> = flowOf(PagingData.empty())): HomeState
}