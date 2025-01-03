package br.com.challenge.kotlinpop.common.domain.model.pr.repox

import br.com.challenge.kotlinpop.common.domain.model.pr.license.GithubPRResultLicenseDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.owner.GithubPRResultOwnerDomain
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ZERO
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT

data class GithubPRResultRepoXDomain(
    val allowForking: Boolean? = false,
    val archiveUrl: String? = EMPTY_STRING_DEFAULT,
    val archived: Boolean? = false,
    val assigneesUrl: String? = EMPTY_STRING_DEFAULT,
    val blobsUrl: String? = EMPTY_STRING_DEFAULT,
    val branchesUrl: String? = EMPTY_STRING_DEFAULT,
    val cloneUrl: String? = EMPTY_STRING_DEFAULT,
    val collaboratorsUrl: String? = EMPTY_STRING_DEFAULT,
    val commentsUrl: String? = EMPTY_STRING_DEFAULT,
    val commitsUrl: String? = EMPTY_STRING_DEFAULT,
    val compareUrl: String? = EMPTY_STRING_DEFAULT,
    val contentsUrl: String? = EMPTY_STRING_DEFAULT,
    val contributorsUrl: String? = EMPTY_STRING_DEFAULT,
    val createdAt: String? = EMPTY_STRING_DEFAULT,
    val defaultBranch: String? = EMPTY_STRING_DEFAULT,
    val deploymentsUrl: String? = EMPTY_STRING_DEFAULT,
    val description: String? = EMPTY_STRING_DEFAULT,
    val disabled: Boolean? = false,
    val downloadsUrl: String? = EMPTY_STRING_DEFAULT,
    val eventsUrl: String? = EMPTY_STRING_DEFAULT,
    val fork: Boolean? = false,
    val forks: Int? = KEY_NUMBER_ZERO,
    val forksCount: Int? = KEY_NUMBER_ZERO,
    val forksUrl: String? = EMPTY_STRING_DEFAULT,
    val fullName: String? = EMPTY_STRING_DEFAULT,
    val gitCommitsUrl: String? = EMPTY_STRING_DEFAULT,
    val gitRefsUrl: String? = EMPTY_STRING_DEFAULT,
    val gitTagsUrl: String? = EMPTY_STRING_DEFAULT,
    val gitUrl: String? = EMPTY_STRING_DEFAULT,
    val hasDiscussions: Boolean? = false,
    val hasDownloads: Boolean? = false,
    val hasIssues: Boolean? = false,
    val hasPages: Boolean? = false,
    val hasProjects: Boolean? = false,
    val hasWiki: Boolean? = false,
    val homepage: String? = EMPTY_STRING_DEFAULT,
    val hooksUrl: String? = EMPTY_STRING_DEFAULT,
    val htmlUrl: String? = EMPTY_STRING_DEFAULT,
    val id: Int? = KEY_NUMBER_ZERO,
    val isTemplate: Boolean? = false,
    val issueCommentUrl: String? = EMPTY_STRING_DEFAULT,
    val issueEventsUrl: String? = EMPTY_STRING_DEFAULT,
    val issuesUrl: String? = EMPTY_STRING_DEFAULT,
    val keysUrl: String? = EMPTY_STRING_DEFAULT,
    val labelsUrl: String? = EMPTY_STRING_DEFAULT,
    val language: String? = EMPTY_STRING_DEFAULT,
    val languagesUrl: String? = EMPTY_STRING_DEFAULT,
    val githubPRResultLicenseDomain: GithubPRResultLicenseDomain? = GithubPRResultLicenseDomain(),
    val mergesUrl: String? = EMPTY_STRING_DEFAULT,
    val milestonesUrl: String? = EMPTY_STRING_DEFAULT,
    val mirrorUrl: String? = EMPTY_STRING_DEFAULT,
    val name: String? = EMPTY_STRING_DEFAULT,
    val nodeId: String? = EMPTY_STRING_DEFAULT,
    val notificationsUrl: String? = EMPTY_STRING_DEFAULT,
    val openIssues: Int? = KEY_NUMBER_ZERO,
    val openIssuesCount: Int? = KEY_NUMBER_ZERO,
    val githubPRResultOwnerDomain: GithubPRResultOwnerDomain? = GithubPRResultOwnerDomain(),
    val `private`: Boolean? = false,
    val pullsUrl: String? = EMPTY_STRING_DEFAULT,
    val pushedAt: String? = EMPTY_STRING_DEFAULT,
    val releasesUrl: String? = EMPTY_STRING_DEFAULT,
    val size: Int? = KEY_NUMBER_ZERO,
    val sshUrl: String? = EMPTY_STRING_DEFAULT,
    val stargazersCount: Int? = KEY_NUMBER_ZERO,
    val stargazersUrl: String? = EMPTY_STRING_DEFAULT,
    val statusesUrl: String? = EMPTY_STRING_DEFAULT,
    val subscribersUrl: String? = EMPTY_STRING_DEFAULT,
    val subscriptionUrl: String? = EMPTY_STRING_DEFAULT,
    val svnUrl: String? = EMPTY_STRING_DEFAULT,
    val tagsUrl: String? = EMPTY_STRING_DEFAULT,
    val teamsUrl: String? = EMPTY_STRING_DEFAULT,
    val topics: List<String?>? = listOf(),
    val treesUrl: String? = EMPTY_STRING_DEFAULT,
    val updatedAt: String? = EMPTY_STRING_DEFAULT,
    val url: String? = EMPTY_STRING_DEFAULT,
    val visibility: String? = EMPTY_STRING_DEFAULT,
    val watchers: Int? = KEY_NUMBER_ZERO,
    val watchersCount: Int? = KEY_NUMBER_ZERO,
    val webCommitSignoffRequired: Boolean? = false
)