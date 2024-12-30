package br.com.challenge.kotlinpop.common.error.exception

import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import kotlinx.serialization.Serializable

@Serializable
data class ApiException(
    val error: String? = null,
    val description: String? = EMPTY_STRING_DEFAULT,
    val status: String? = EMPTY_STRING_DEFAULT,
    val action: String? = EMPTY_STRING_DEFAULT,
    override val message: String? = EMPTY_STRING_DEFAULT
) : Exception(message)
