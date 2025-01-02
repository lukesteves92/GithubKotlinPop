package br.com.challenge.kotlinpop.core.wrapper.main

import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import io.ktor.client.statement.HttpResponse

interface RequestWrapper {
    suspend fun <T : Any> wrapper(
        call: suspend () -> HttpResponse,
        responseHandler: suspend (HttpResponse) -> T
    ): ApiResult<T, NetworkApiError>
}