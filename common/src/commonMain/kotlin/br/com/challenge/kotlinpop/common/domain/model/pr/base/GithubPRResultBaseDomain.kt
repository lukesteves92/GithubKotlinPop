package br.com.challenge.kotlinpop.common.domain.model.pr.base

import br.com.challenge.kotlinpop.common.domain.model.pr.repo.GithubPRResultRepoDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.user.GithubPRResultUserXXDomain
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT

data class GithubPRResultBaseDomain(
    val label: String? = EMPTY_STRING_DEFAULT,
    val ref: String? = EMPTY_STRING_DEFAULT,
    val githubPRResultRepoDomain: GithubPRResultRepoDomain? = GithubPRResultRepoDomain(),
    val sha: String? = EMPTY_STRING_DEFAULT,
    val user: GithubPRResultUserXXDomain? = GithubPRResultUserXXDomain()
)