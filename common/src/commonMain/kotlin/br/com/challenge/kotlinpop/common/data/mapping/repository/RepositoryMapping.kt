package br.com.challenge.kotlinpop.common.data.mapping.repository

import br.com.challenge.kotlinpop.common.data.response.repository.item.GithubRepositoryItemResponse
import br.com.challenge.kotlinpop.common.data.response.repository.license.GithubRepositoryLicenseResponse
import br.com.challenge.kotlinpop.common.data.response.repository.owner.GithubRepositoryOwnerResponse
import br.com.challenge.kotlinpop.common.data.response.repository.result.GithubRepositoryResultResponse
import br.com.challenge.kotlinpop.common.domain.model.repository.item.GithubRepositoryItemDomain
import br.com.challenge.kotlinpop.common.domain.model.repository.license.GithubRepositoryLicenseDomain
import br.com.challenge.kotlinpop.common.domain.model.repository.owner.GithubRepositoryOwnerDomain
import br.com.challenge.kotlinpop.common.domain.model.repository.result.GithubRepositoryResultDomain

fun GithubRepositoryItemResponse.toDomain() = GithubRepositoryItemDomain(
    allowForking = this.allowForking,
    archiveUrl = this.archiveUrl,
    archived = this.archived,
    assigneesUrl = this.assigneesUrl,
    blobsUrl = this.blobsUrl,
    branchesUrl = this.branchesUrl,
    cloneUrl = this.cloneUrl,
    collaboratorsUrl = this.collaboratorsUrl,
    commentsUrl = this.commentsUrl,
    commitsUrl = this.commitsUrl,
    compareUrl = this.compareUrl,
    contentsUrl = this.contentsUrl,
    contributorsUrl = this.contributorsUrl,
    createdAt = this.createdAt,
    defaultBranch = this.defaultBranch,
    deploymentsUrl = this.deploymentsUrl,
    description = this.description,
    disabled = this.disabled,
    downloadsUrl = this.downloadsUrl,
    eventsUrl = this.eventsUrl,
    fork = this.fork,
    forks = this.forks,
    forksCount = this.forksCount,
    forksUrl = this.forksUrl,
    fullName = this.fullName,
    gitCommitsUrl = this.gitCommitsUrl,
    gitRefsUrl = this.gitRefsUrl,
    gitTagsUrl = this.gitTagsUrl,
    gitUrl = this.gitUrl,
    hasDiscussions = this.hasDiscussions,
    hasDownloads = this.hasDownloads,
    hasIssues = this.hasIssues,
    hasPages = this.hasPages,
    hasProjects = this.hasProjects,
    hasWiki = this.hasWiki,
    homepage = this.homepage,
    hooksUrl = this.hooksUrl,
    htmlUrl = this.htmlUrl,
    id = this.id,
    isTemplate = this.isTemplate,
    issueCommentUrl = this.issueCommentUrl,
    issueEventsUrl = this.issueEventsUrl,
    issuesUrl = this.issuesUrl,
    keysUrl = this.keysUrl,
    labelsUrl = this.labelsUrl,
    language = this.language,
    languagesUrl = this.languagesUrl,
    githubRepositoryLicenseDomain = this.githubRepositoryLicenseDomain?.toDomain(),
    mergesUrl = this.mergesUrl,
    milestonesUrl = this.milestonesUrl,
    mirrorUrl = this.mirrorUrl,
    name = this.name,
    nodeId = this.nodeId,
    notificationsUrl = this.notificationsUrl,
    openIssues = this.openIssues,
    openIssuesCount = this.openIssuesCount,
    githubRepositoryOwnerDomain = this.githubRepositoryOwnerDomain?.toDomain(),
    private = this.private,
    pullsUrl = this.pullsUrl,
    pushedAt = this.pushedAt,
    releasesUrl = this.releasesUrl,
    score = this.score,
    size = this.size,
    sshUrl = this.sshUrl,
    stargazersCount = this.stargazersCount,
    stargazersUrl = this.stargazersUrl,
    statusesUrl = this.statusesUrl,
    subscribersUrl = this.subscribersUrl,
    subscriptionUrl = this.subscriptionUrl,
    svnUrl = this.svnUrl,
    tagsUrl = this.tagsUrl,
    teamsUrl = this.teamsUrl,
    topics = this.topics,
    treesUrl = this.treesUrl,
    updatedAt = this.updatedAt,
    url = this.url,
    visibility = this.visibility,
    watchers = this.watchers,
    watchersCount = this.watchersCount,
    webCommitSignoffRequired = this.webCommitSignoffRequired
)

fun GithubRepositoryLicenseResponse.toDomain() = GithubRepositoryLicenseDomain(
    key = this.key,
    name = this.name,
    nodeId = this.nodeId,
    spdxId = this.spdxId,
    url = this.url
)

fun GithubRepositoryOwnerResponse.toDomain() = GithubRepositoryOwnerDomain(
    avatarUrl = this.avatarUrl,
    eventsUrl = this.eventsUrl,
    followersUrl = this.followersUrl,
    followingUrl = this.followingUrl,
    gistsUrl = this.gistsUrl,
    gravatarId = this.gravatarId,
    htmlUrl = this.htmlUrl,
    id = this.id,
    login = this.login,
    nodeId = this.nodeId,
    organizationsUrl = this.organizationsUrl,
    receivedEventsUrl = this.receivedEventsUrl,
    reposUrl = this.reposUrl,
    siteAdmin = this.siteAdmin,
    starredUrl = this.starredUrl,
    subscriptionsUrl = this.subscriptionsUrl,
    type = this.type,
    url = this.url,
    userViewType = this.userViewType
)

fun GithubRepositoryResultResponse.toDomain() = GithubRepositoryResultDomain(
    incompleteResults = this.incompleteResults,
    githubRepositoryItemDomain = this.githubRepositoryItemDomain?.map { it?.toDomain() },
    totalCount = this.totalCount
)