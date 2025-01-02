package com.challenge.kotlinpop.domain.usecase.home


import androidx.paging.PagingData
import br.com.challenge.kotlinpop.common.domain.model.repository.item.GithubRepositoryItemDomain
import br.com.challenge.kotlinpop.common.domain.request.PagingRequest
import com.challenge.kotlinpop.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetHomeUseCase(private val repository: HomeRepository) {
    fun getGithubRepos(): Flow<PagingData<GithubRepositoryItemDomain>> {
        return repository.getGithubRepos(pagingRequest = PagingRequest())
    }
}