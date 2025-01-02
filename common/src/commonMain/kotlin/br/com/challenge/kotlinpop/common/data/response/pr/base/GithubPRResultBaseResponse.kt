package br.com.challenge.kotlinpop.common.data.response.pr.base


import br.com.challenge.kotlinpop.common.data.response.pr.repo.GithubPRResultRepoResponse
import br.com.challenge.kotlinpop.common.data.response.pr.user.GithubPRResultUserXXResponse
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultBaseResponse(
    @SerialName("label")
    val label: String? = EMPTY_STRING_DEFAULT,
    @SerialName("ref")
    val ref: String? = EMPTY_STRING_DEFAULT,
    @SerialName("repo")
    val githubPRResultRepoResponse: GithubPRResultRepoResponse? = GithubPRResultRepoResponse(),
    @SerialName("sha")
    val sha: String? = EMPTY_STRING_DEFAULT,
    @SerialName("user")
    val user: GithubPRResultUserXXResponse? = GithubPRResultUserXXResponse()
)