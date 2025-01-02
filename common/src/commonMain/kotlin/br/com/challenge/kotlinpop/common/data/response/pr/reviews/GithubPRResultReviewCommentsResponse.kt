package br.com.challenge.kotlinpop.common.data.response.pr.reviews

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultReviewCommentsResponse(
    @SerialName("href")
    val href: String? = null
)