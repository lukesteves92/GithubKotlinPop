package br.com.challenge.kotlinpop.common.data.response.pr.main

import br.com.challenge.kotlinpop.common.data.response.pr.label.GithubPRResultLabelResponse
import br.com.challenge.kotlinpop.common.data.response.pr.links.GithubPRResultLinksResponse
import br.com.challenge.kotlinpop.common.data.response.pr.user.GithubPRResultUserXXResponse
import br.com.challenge.kotlinpop.common.data.response.pr.base.GithubPRResultBaseResponse
import br.com.challenge.kotlinpop.common.data.response.pr.head.GithubPRResultHeadResponse
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultItemResponse(
    @SerialName("active_lock_reason")
    val activeLockReason: String? = EMPTY_STRING_DEFAULT,
    @SerialName("assignee")
    val assignee: String? = EMPTY_STRING_DEFAULT,
    @SerialName("assignees")
    val assignees: List<String?>? = listOf(),
    @SerialName("author_association")
    val authorAssociation: String? = EMPTY_STRING_DEFAULT,
    @SerialName("auto_merge")
    val autoMerge: String? = EMPTY_STRING_DEFAULT,
    @SerialName("base")
    val githubPRResultBaseResponse: GithubPRResultBaseResponse? = GithubPRResultBaseResponse(),
    @SerialName("body")
    val body: String? = EMPTY_STRING_DEFAULT,
    @SerialName("closed_at")
    val closedAt: String? = EMPTY_STRING_DEFAULT,
    @SerialName("comments_url")
    val commentsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("commits_url")
    val commitsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("created_at")
    val createdAt: String? = EMPTY_STRING_DEFAULT,
    @SerialName("diff_url")
    val diffUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("draft")
    val draft: Boolean? = false,
    @SerialName("head")
    val githubPRResultHeadResponse: GithubPRResultHeadResponse? = GithubPRResultHeadResponse(),
    @SerialName("html_url")
    val htmlUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("issue_url")
    val issueUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("labels")
    val githubPRResultLabelResponse: List<GithubPRResultLabelResponse>? = listOf(),
    @SerialName("_links")
    val githubPRResultLinksResponse: GithubPRResultLinksResponse? = GithubPRResultLinksResponse(),
    @SerialName("locked")
    val locked: Boolean? = false,
    @SerialName("merge_commit_sha")
    val mergeCommitSha: String? = EMPTY_STRING_DEFAULT,
    @SerialName("merged_at")
    val mergedAt: String? = EMPTY_STRING_DEFAULT,
    @SerialName("milestone")
    val milestone: String? = EMPTY_STRING_DEFAULT,
    @SerialName("node_id")
    val nodeId: String? = EMPTY_STRING_DEFAULT,
    @SerialName("number")
    val number: Int? = 0,
    @SerialName("patch_url")
    val patchUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("requested_reviewers")
    val requestedReviewers: List<String?>? = listOf(),
    @SerialName("requested_teams")
    val requestedTeams: List<String?>? = listOf(),
    @SerialName("review_comment_url")
    val reviewCommentUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("review_comments_url")
    val reviewCommentsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("state")
    val state: String? = EMPTY_STRING_DEFAULT,
    @SerialName("statuses_url")
    val statusesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("title")
    val title: String? = EMPTY_STRING_DEFAULT,
    @SerialName("updated_at")
    val updatedAt: String? = EMPTY_STRING_DEFAULT,
    @SerialName("url")
    val url: String? = EMPTY_STRING_DEFAULT,
    @SerialName("user")
    val user: GithubPRResultUserXXResponse? = GithubPRResultUserXXResponse()
)