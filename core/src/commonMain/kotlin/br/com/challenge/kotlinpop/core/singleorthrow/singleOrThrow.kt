package br.com.challenge.kotlinpop.core.singleorthrow

import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.error.api.ApiError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single

suspend inline fun <T, E : ApiError> Flow<ApiResult<T, E>>.singleOrThrow(
    success: ((T) -> Unit),
    error: ((E) -> Unit)
) {
    try {
        when (val result = single()) {
            is ApiResult.Success -> success.invoke(result.data)
            is ApiResult.Error -> error.invoke(result.error)
        }
    } catch (e: Exception) {
        throw e
    }
}