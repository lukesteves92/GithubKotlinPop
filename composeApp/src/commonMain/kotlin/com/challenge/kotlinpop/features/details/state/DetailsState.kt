package com.challenge.kotlinpop.features.details.state

import br.com.challenge.kotlinpop.common.domain.model.pr.main.GithubPRResultItemDomain

sealed interface DetailsState {
    data object Idle : DetailsState
    data object Loading : DetailsState
    data object OnBackPressed : DetailsState
    data class ShowData(val data: List<GithubPRResultItemDomain>, val repo: String) : DetailsState
    data class ShowError(val message: String) : DetailsState
}