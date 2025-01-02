package com.challenge.kotlinpop.domain.usecase.main

import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import kotlinx.coroutines.flow.Flow

abstract class UseCase<in Params, out T>(
    private val function: (Params) -> Flow<ApiResult<T, NetworkApiError>>
) {
    operator fun invoke(params: Params): Flow<ApiResult<T, NetworkApiError>> = function(params)
}