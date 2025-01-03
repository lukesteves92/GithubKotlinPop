package com.challenge.kotlinpop.domain.repository.details

import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.domain.model.pr.main.GithubPRResultItemDomain
import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {
    fun getGithubPullRequests(creator: String, repo: String): Flow<ApiResult<List<GithubPRResultItemDomain>, NetworkApiError>>
}