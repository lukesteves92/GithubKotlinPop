package br.com.challenge.kotlinpop.core.wrapper.impl

import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.error.exception.ApiException
import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import br.com.challenge.kotlinpop.common.extensions.model.toDefaultError
import br.com.challenge.kotlinpop.common.extensions.model.toDefaultInternetError
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_API_CODE_SUCCESS_MAX
import br.com.challenge.kotlinpop.common.util.constants.Constants.Api.KEY_API_CODE_SUCCESS_MIN
import br.com.challenge.kotlinpop.common.util.enums.network.NetworkErrorType
import br.com.challenge.kotlinpop.core.wrapper.main.RequestWrapper
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

class RequestWrapperImpl : RequestWrapper {
    override suspend fun <T : Any> wrapper(
        call: suspend () -> HttpResponse,
        responseHandler: suspend (HttpResponse) -> T
    ): ApiResult<T, NetworkApiError> {
        val response = try {
            call.invoke()
        } catch (exception: IOException) {
            return ApiResult.Error(
                NetworkErrorType.NO_INTERNET.toDefaultInternetError()
            )
        } catch (e: UnresolvedAddressException) {
            return ApiResult.Error(
                NetworkErrorType.NO_INTERNET.toDefaultInternetError()
            )
        } catch (e: SerializationException) {
            return ApiResult.Error(
                NetworkErrorType.SERIALIZATION.toDefaultError()
            )
        } catch (e: Exception) {
            return ApiResult.Error(
                NetworkErrorType.SERVER_ERROR.toDefaultError()
            )
        }

        return when (response.status.value) {
            in KEY_API_CODE_SUCCESS_MIN..KEY_API_CODE_SUCCESS_MAX -> {
                val data = try {
                    responseHandler(response)
                } catch (e: Exception) {
                    return ApiResult.Error(
                        NetworkErrorType.SERIALIZATION.toDefaultError()
                    )
                }
                ApiResult.Success(data)
            }

            else -> {
                val apiErrorResponse = try {
                    response.body<ApiException>()
                } catch (e: Exception) {
                    return ApiResult.Error(
                        NetworkErrorType.SERVER_ERROR.toDefaultError()
                    )
                }

                ApiResult.Error(
                    NetworkApiError(
                        error = apiErrorResponse.error.orEmpty(),
                        status = apiErrorResponse.status.orEmpty(),
                        message = apiErrorResponse.message.orEmpty(),
                        type = NetworkErrorType.CUSTOM_ERROR
                    )
                )
            }
        }
    }
}