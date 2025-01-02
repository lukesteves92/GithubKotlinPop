package br.com.challenge.kotlinpop.common.data.response.pr.self

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultSelfResponse(
    @SerialName("href")
    val href: String? = null
)