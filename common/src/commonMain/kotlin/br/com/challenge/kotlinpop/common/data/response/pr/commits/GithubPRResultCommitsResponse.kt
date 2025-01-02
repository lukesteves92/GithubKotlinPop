package br.com.challenge.kotlinpop.common.data.response.pr.commits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultCommitsResponse(
    @SerialName("href")
    val href: String? = null
)