package com.challenge.kotlinpop.domain.repository.home

import androidx.paging.PagingData
import br.com.challenge.kotlinpop.common.domain.model.repository.item.GithubRepositoryItemDomain
import br.com.challenge.kotlinpop.common.domain.request.PagingRequest
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getGithubRepos(pagingRequest: PagingRequest): Flow<PagingData<GithubRepositoryItemDomain>>
}