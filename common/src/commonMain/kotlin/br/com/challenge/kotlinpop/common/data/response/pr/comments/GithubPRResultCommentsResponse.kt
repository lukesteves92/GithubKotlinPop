package br.com.challenge.kotlinpop.common.data.response.pr.comments

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultCommentsResponse(
    @SerialName("href")
    val href: String? = null
)