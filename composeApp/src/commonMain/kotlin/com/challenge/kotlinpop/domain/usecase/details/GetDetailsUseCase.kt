package com.challenge.kotlinpop.domain.usecase.details

import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.domain.model.pr.main.GithubPRResultItemDomain
import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import com.challenge.kotlinpop.domain.repository.details.DetailsRepository
import kotlinx.coroutines.flow.Flow

class GetDetailsUseCase(private val repository: DetailsRepository) {
    fun getGithubPullRequests(creator: String, repo: String): Flow<ApiResult<List<GithubPRResultItemDomain>, NetworkApiError>> =
        repository.getGithubPullRequests(creator = creator, repo = repo)
}