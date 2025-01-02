package br.com.challenge.kotlinpop.common.data.response.pr.head

import br.com.challenge.kotlinpop.common.data.response.pr.repox.GithubPRResultRepoXResponse
import br.com.challenge.kotlinpop.common.data.response.pr.user.GithubPRResultUserXXResponse
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultHeadResponse(
    @SerialName("label")
    val label: String? = EMPTY_STRING_DEFAULT,
    @SerialName("ref")
    val ref: String? = EMPTY_STRING_DEFAULT,
    @SerialName("repo")
    val repo: GithubPRResultRepoXResponse? = GithubPRResultRepoXResponse(),
    @SerialName("sha")
    val sha: String? = EMPTY_STRING_DEFAULT,
    @SerialName("user")
    val user: GithubPRResultUserXXResponse? = GithubPRResultUserXXResponse()
)