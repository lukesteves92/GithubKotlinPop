package br.com.challenge.kotlinpop.common.data.response.pr.issue

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultIssueResponse(
    @SerialName("href")
    val href: String? = null
)