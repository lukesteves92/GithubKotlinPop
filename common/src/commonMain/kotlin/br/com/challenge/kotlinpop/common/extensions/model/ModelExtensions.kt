package br.com.challenge.kotlinpop.common.extensions.model

import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_API_ERROR_MESSAGE_DEFAULT
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_INTERNET_ERROR_MESSAGE_DEFAULT
import br.com.challenge.kotlinpop.common.util.enums.network.NetworkErrorType

fun NetworkErrorType.toDefaultError() = NetworkApiError(
    type = this,
    message = KEY_API_ERROR_MESSAGE_DEFAULT
)

fun NetworkErrorType.toDefaultInternetError() = NetworkApiError(
    type = this,
    message = KEY_INTERNET_ERROR_MESSAGE_DEFAULT,
)