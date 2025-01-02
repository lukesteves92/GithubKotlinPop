package br.com.challenge.kotlinpop.common.data.response.pr.label

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultLabelResponse(
    @SerialName("color")
    val color: String? = null,
    @SerialName("default")
    val default: Boolean? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("id")
    val id: Long? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("node_id")
    val nodeId: String? = null,
    @SerialName("url")
    val url: String? = null
)