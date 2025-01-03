package com.challenge.kotlinpop.data.repository.details

import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.data.mapping.pr.toDomain
import br.com.challenge.kotlinpop.common.data.response.pr.main.GithubPRResultItemResponse
import br.com.challenge.kotlinpop.common.domain.model.pr.main.GithubPRResultItemDomain
import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_API_QUERY_CREATOR
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_API_QUERY_REPO
import br.com.challenge.kotlinpop.common.util.enums.network.NetworkErrorType
import br.com.challenge.kotlinpop.core.endpoints.details.DetailsRoutes
import br.com.challenge.kotlinpop.core.wrapper.main.RequestWrapper
import com.challenge.kotlinpop.domain.repository.details.DetailsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DetailsRepositoryImpl(
    private val httpClient: HttpClient,
    private val wrapper: RequestWrapper
) : DetailsRepository {
    override fun getGithubPullRequests(
        creator: String,
        repo: String
    ): Flow<ApiResult<List<GithubPRResultItemDomain>, NetworkApiError>> = flow {
        val result = wrapper.wrapper(
            call = {
                httpClient.get(
                    DetailsRoutes.GetPullRequests.withParams(
                        KEY_API_QUERY_CREATOR to creator,
                        KEY_API_QUERY_REPO to repo
                    )
                )
            },
            responseHandler = { response ->
                response.body<List<GithubPRResultItemResponse>>().map { data -> data.toDomain() }
            }
        )
        emit(result)
    }.catch {
        emit(ApiResult.Error(NetworkApiError(type = NetworkErrorType.SERVER_ERROR)))
    }.flowOn(Dispatchers.IO)
}