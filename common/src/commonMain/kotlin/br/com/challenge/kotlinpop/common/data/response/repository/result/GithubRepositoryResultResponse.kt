package br.com.challenge.kotlinpop.common.data.response.repository.result


import br.com.challenge.kotlinpop.common.data.response.repository.item.GithubRepositoryItemResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryResultResponse(
    @SerialName("incomplete_results")
    val incompleteResults: Boolean? = null,
    @SerialName("items")
    val githubRepositoryItemResponse: List<GithubRepositoryItemResponse>? = emptyList(),
    @SerialName("total_count")
    val totalCount: Int? = null
)