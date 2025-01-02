package com.challenge.kotlinpop.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.challenge.kotlinpop.common.data.mapping.repository.toDomain
import br.com.challenge.kotlinpop.common.data.response.repository.item.GithubRepositoryItemResponse
import br.com.challenge.kotlinpop.common.domain.model.repository.item.GithubRepositoryItemDomain
import br.com.challenge.kotlinpop.common.domain.request.PagingRequest
import br.com.challenge.kotlinpop.core.paging.BasePagingSource
import br.com.challenge.kotlinpop.core.wrapper.main.RequestWrapper
import com.challenge.kotlinpop.domain.repository.HomeRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class HomeRepositoryImpl(
    private val httpClient: HttpClient,
    private val wrapper: RequestWrapper
): HomeRepository {
    override fun getGithubRepos(pagingRequest: PagingRequest): Flow<PagingData<GithubRepositoryItemDomain>> = Pager(
        config = PagingConfig(pageSize = pagingRequest.limit, initialLoadSize = pagingRequest.limit, enablePlaceholders = false),
        pagingSourceFactory = {
           BasePagingSource { page, _ ->
               wrapper.wrapper(
                   call = {
                       httpClient.get("/search/repositories") {
                           parameter("page", page)
                           parameter("q", pagingRequest.language)
                           parameter("sort", pagingRequest.sort)
                       }
                   },
                   responseHandler = { response -> response.body<List<GithubRepositoryItemResponse>>().map { it.toDomain() } }
               )
           }
        }
    ).flow.flowOn(Dispatchers.IO)
}