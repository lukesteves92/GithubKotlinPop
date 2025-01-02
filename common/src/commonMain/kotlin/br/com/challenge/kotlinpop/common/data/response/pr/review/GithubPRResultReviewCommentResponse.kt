package br.com.challenge.kotlinpop.common.data.response.pr.review

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultReviewCommentResponse(
    @SerialName("href")
    val href: String? = null
)