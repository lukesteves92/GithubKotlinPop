package br.com.challenge.kotlinpop.common.domain.model.pr.head

import br.com.challenge.kotlinpop.common.domain.model.pr.repox.GithubPRResultRepoXDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.user.GithubPRResultUserXXDomain
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT

data class GithubPRResultHeadDomain(
    val label: String? = EMPTY_STRING_DEFAULT,
    val ref: String? = EMPTY_STRING_DEFAULT,
    val repo: GithubPRResultRepoXDomain? = GithubPRResultRepoXDomain(),
    val sha: String? = EMPTY_STRING_DEFAULT,
    val user: GithubPRResultUserXXDomain? = GithubPRResultUserXXDomain()
)