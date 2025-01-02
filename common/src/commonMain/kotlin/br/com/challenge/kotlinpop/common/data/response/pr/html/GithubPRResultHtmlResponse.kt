package br.com.challenge.kotlinpop.common.data.response.pr.html

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultHtmlResponse(
    @SerialName("href")
    val href: String? = null
)