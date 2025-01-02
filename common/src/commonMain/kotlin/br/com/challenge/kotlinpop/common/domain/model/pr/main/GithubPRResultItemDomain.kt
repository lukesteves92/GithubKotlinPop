package br.com.challenge.kotlinpop.common.domain.model.pr.main

import br.com.challenge.kotlinpop.common.domain.model.pr.label.GithubPRResultLabelDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.links.GithubPRResultLinksDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.user.GithubPRResultUserXXDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.base.GithubPRResultBaseDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.head.GithubPRResultHeadDomain
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ONE
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ZERO
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT

data class GithubPRResultItemDomain(
    val activeLockReason: String? = EMPTY_STRING_DEFAULT,
    val assignee: String? = EMPTY_STRING_DEFAULT,
    val assignees: List<String?>? = listOf(),
    val authorAssociation: String? = EMPTY_STRING_DEFAULT,
    val autoMerge: String? = EMPTY_STRING_DEFAULT,
    val githubPRResultBaseDomain: GithubPRResultBaseDomain? = GithubPRResultBaseDomain(),
    val body: String? = EMPTY_STRING_DEFAULT,
    val closedAt: String? = EMPTY_STRING_DEFAULT,
    val commentsUrl: String? = EMPTY_STRING_DEFAULT,
    val commitsUrl: String? = EMPTY_STRING_DEFAULT,
    val createdAt: String? = EMPTY_STRING_DEFAULT,
    val diffUrl: String? = EMPTY_STRING_DEFAULT,
    val draft: Boolean? = false,
    val githubPRResultHeadDomain: GithubPRResultHeadDomain? = GithubPRResultHeadDomain(),
    val htmlUrl: String? = EMPTY_STRING_DEFAULT,
    val id: Int? = KEY_NUMBER_ZERO,
    val issueUrl: String? = EMPTY_STRING_DEFAULT,
    val githubPRResultLabelDomain: List<GithubPRResultLabelDomain>? = listOf(),
    val githubPRResultLinksDomain: GithubPRResultLinksDomain? = GithubPRResultLinksDomain(),
    val locked: Boolean? = false,
    val mergeCommitSha: String? = EMPTY_STRING_DEFAULT,
    val mergedAt: String? = EMPTY_STRING_DEFAULT,
    val milestone: String? = EMPTY_STRING_DEFAULT,
    val nodeId: String? = EMPTY_STRING_DEFAULT,
    val number: Int? = KEY_NUMBER_ONE,
    val patchUrl: String? = EMPTY_STRING_DEFAULT,
    val requestedReviewers: List<String?>? = listOf(),
    val requestedTeams: List<String?>? = listOf(),
    val reviewCommentUrl: String? = EMPTY_STRING_DEFAULT,
    val reviewCommentsUrl: String? = EMPTY_STRING_DEFAULT,
    val state: String? = EMPTY_STRING_DEFAULT,
    val statusesUrl: String? = EMPTY_STRING_DEFAULT,
    val title: String? = EMPTY_STRING_DEFAULT,
    val updatedAt: String? = EMPTY_STRING_DEFAULT,
    val url: String? = EMPTY_STRING_DEFAULT,
    val user: GithubPRResultUserXXDomain? = GithubPRResultUserXXDomain()
)