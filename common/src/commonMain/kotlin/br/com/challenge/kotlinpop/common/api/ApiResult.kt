package br.com.challenge.kotlinpop.common.api

import br.com.challenge.kotlinpop.common.error.api.ApiError


sealed interface ApiResult<out D, out E : ApiError> {
    data class Success<out D>(val data: D) : ApiResult<D, Nothing>
    data class Error<out E : ApiError>(val error: E) : ApiResult<Nothing, E>
}

inline fun <T, E : ApiError, R> ApiResult<T, E>.map(map: (T) -> R): ApiResult<R, E> {
    return when (this) {
        is ApiResult.Error -> ApiResult.Error(error)
        is ApiResult.Success -> ApiResult.Success(map(data))
    }
}