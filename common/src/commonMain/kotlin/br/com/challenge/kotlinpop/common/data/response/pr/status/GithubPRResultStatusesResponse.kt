package br.com.challenge.kotlinpop.common.data.response.pr.status

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultStatusesResponse(
    @SerialName("href")
    val href: String? = null
)