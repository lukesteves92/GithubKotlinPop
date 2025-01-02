package br.com.challenge.kotlinpop.common.data.response.pr.repox

import br.com.challenge.kotlinpop.common.data.response.pr.license.GithubPRResultLicenseResponse
import br.com.challenge.kotlinpop.common.data.response.pr.owner.GithubPRResultOwnerResponse
import br.com.challenge.kotlinpop.common.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultRepoXResponse(
    @SerialName("allow_forking")
    val allowForking: Boolean? = false,
    @SerialName("archive_url")
    val archiveUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("archived")
    val archived: Boolean? = false,
    @SerialName("assignees_url")
    val assigneesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("blobs_url")
    val blobsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("branches_url")
    val branchesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("clone_url")
    val cloneUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("collaborators_url")
    val collaboratorsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("comments_url")
    val commentsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("commits_url")
    val commitsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("compare_url")
    val compareUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("contents_url")
    val contentsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("contributors_url")
    val contributorsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("created_at")
    val createdAt: String? = EMPTY_STRING_DEFAULT,
    @SerialName("default_branch")
    val defaultBranch: String? = EMPTY_STRING_DEFAULT,
    @SerialName("deployments_url")
    val deploymentsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("description")
    val description: String? = EMPTY_STRING_DEFAULT,
    @SerialName("disabled")
    val disabled: Boolean? = false,
    @SerialName("downloads_url")
    val downloadsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("events_url")
    val eventsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("fork")
    val fork: Boolean? = false,
    @SerialName("forks")
    val forks: Int? = 0,
    @SerialName("forks_count")
    val forksCount: Int? = 0,
    @SerialName("forks_url")
    val forksUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("full_name")
    val fullName: String? = EMPTY_STRING_DEFAULT,
    @SerialName("git_commits_url")
    val gitCommitsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("git_refs_url")
    val gitRefsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("git_tags_url")
    val gitTagsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("git_url")
    val gitUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("has_discussions")
    val hasDiscussions: Boolean? = false,
    @SerialName("has_downloads")
    val hasDownloads: Boolean? = false,
    @SerialName("has_issues")
    val hasIssues: Boolean? = false,
    @SerialName("has_pages")
    val hasPages: Boolean? = false,
    @SerialName("has_projects")
    val hasProjects: Boolean? = false,
    @SerialName("has_wiki")
    val hasWiki: Boolean? = false,
    @SerialName("homepage")
    val homepage: String? = EMPTY_STRING_DEFAULT,
    @SerialName("hooks_url")
    val hooksUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("html_url")
    val htmlUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("is_template")
    val isTemplate: Boolean? = false,
    @SerialName("issue_comment_url")
    val issueCommentUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("issue_events_url")
    val issueEventsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("issues_url")
    val issuesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("keys_url")
    val keysUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("labels_url")
    val labelsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("language")
    val language: String? = EMPTY_STRING_DEFAULT,
    @SerialName("languages_url")
    val languagesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("license")
    val githubPRResultLicenseResponse: GithubPRResultLicenseResponse? = GithubPRResultLicenseResponse(),
    @SerialName("merges_url")
    val mergesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("milestones_url")
    val milestonesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("mirror_url")
    val mirrorUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("name")
    val name: String? = EMPTY_STRING_DEFAULT,
    @SerialName("node_id")
    val nodeId: String? = EMPTY_STRING_DEFAULT,
    @SerialName("notifications_url")
    val notificationsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("open_issues")
    val openIssues: Int? = 0,
    @SerialName("open_issues_count")
    val openIssuesCount: Int? = 0,
    @SerialName("owner")
    val githubPRResultOwnerResponse: GithubPRResultOwnerResponse? = GithubPRResultOwnerResponse(),
    @SerialName("private")
    val `private`: Boolean? = false,
    @SerialName("pulls_url")
    val pullsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("pushed_at")
    val pushedAt: String? = EMPTY_STRING_DEFAULT,
    @SerialName("releases_url")
    val releasesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("size")
    val size: Int? = 0,
    @SerialName("ssh_url")
    val sshUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("stargazers_count")
    val stargazersCount: Int? = 0,
    @SerialName("stargazers_url")
    val stargazersUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("statuses_url")
    val statusesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("subscribers_url")
    val subscribersUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("subscription_url")
    val subscriptionUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("svn_url")
    val svnUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("tags_url")
    val tagsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("teams_url")
    val teamsUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("topics")
    val topics: List<String?>? = listOf(),
    @SerialName("trees_url")
    val treesUrl: String? = EMPTY_STRING_DEFAULT,
    @SerialName("updated_at")
    val updatedAt: String? = EMPTY_STRING_DEFAULT,
    @SerialName("url")
    val url: String? = EMPTY_STRING_DEFAULT,
    @SerialName("visibility")
    val visibility: String? = EMPTY_STRING_DEFAULT,
    @SerialName("watchers")
    val watchers: Int? = 0,
    @SerialName("watchers_count")
    val watchersCount: Int? = 0,
    @SerialName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean? = false
)