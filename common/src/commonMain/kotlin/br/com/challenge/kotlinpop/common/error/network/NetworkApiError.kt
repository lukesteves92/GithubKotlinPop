package br.com.challenge.kotlinpop.common.error.network

import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import br.com.challenge.kotlinpop.common.error.api.ApiError
import br.com.challenge.kotlinpop.common.util.enums.network.NetworkErrorType

data class NetworkApiError(
    val error: String = EMPTY_STRING_DEFAULT,
    val status: String = EMPTY_STRING_DEFAULT,
    val message: String = EMPTY_STRING_DEFAULT,
    val description: String = EMPTY_STRING_DEFAULT,
    val action: String = EMPTY_STRING_DEFAULT,
    val type: NetworkErrorType = NetworkErrorType.SERVER_ERROR
) : ApiError