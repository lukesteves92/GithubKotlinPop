package br.com.challenge.kotlinpop.common.data.mapping.pr

import br.com.challenge.kotlinpop.common.data.response.pr.base.GithubPRResultBaseResponse
import br.com.challenge.kotlinpop.common.data.response.pr.comments.GithubPRResultCommentsResponse
import br.com.challenge.kotlinpop.common.data.response.pr.commits.GithubPRResultCommitsResponse
import br.com.challenge.kotlinpop.common.data.response.pr.head.GithubPRResultHeadResponse
import br.com.challenge.kotlinpop.common.data.response.pr.html.GithubPRResultHtmlResponse
import br.com.challenge.kotlinpop.common.data.response.pr.issue.GithubPRResultIssueResponse
import br.com.challenge.kotlinpop.common.data.response.pr.main.GithubPRResultItemResponse
import br.com.challenge.kotlinpop.common.data.response.pr.label.GithubPRResultLabelResponse
import br.com.challenge.kotlinpop.common.data.response.pr.license.GithubPRResultLicenseResponse
import br.com.challenge.kotlinpop.common.data.response.pr.links.GithubPRResultLinksResponse
import br.com.challenge.kotlinpop.common.data.response.pr.owner.GithubPRResultOwnerResponse
import br.com.challenge.kotlinpop.common.data.response.pr.repo.GithubPRResultRepoResponse
import br.com.challenge.kotlinpop.common.data.response.pr.repox.GithubPRResultRepoXResponse
import br.com.challenge.kotlinpop.common.data.response.pr.review.GithubPRResultReviewCommentResponse
import br.com.challenge.kotlinpop.common.data.response.pr.reviews.GithubPRResultReviewCommentsResponse
import br.com.challenge.kotlinpop.common.data.response.pr.self.GithubPRResultSelfResponse
import br.com.challenge.kotlinpop.common.data.response.pr.status.GithubPRResultStatusesResponse
import br.com.challenge.kotlinpop.common.data.response.pr.user.GithubPRResultUserXXResponse
import br.com.challenge.kotlinpop.common.domain.model.pr.base.GithubPRResultBaseDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.comments.GithubPRResultCommentsDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.commits.GithubPRResultCommitsDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.head.GithubPRResultHeadDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.html.GithubPRResultHtmlDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.issue.GithubPRResultIssueDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.main.GithubPRResultItemDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.label.GithubPRResultLabelDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.license.GithubPRResultLicenseDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.links.GithubPRResultLinksDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.owner.GithubPRResultOwnerDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.repo.GithubPRResultRepoDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.repox.GithubPRResultRepoXDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.review.GithubPRResultReviewCommentDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.reviews.GithubPRResultReviewCommentsDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.self.GithubPRResultSelfDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.status.GithubPRResultStatusesDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.user.GithubPRResultUserXXDomain

fun GithubPRResultBaseResponse.toDomain() = GithubPRResultBaseDomain(
    label = this.label,
    ref = this.ref,
    githubPRResultRepoDomain = this.githubPRResultRepoResponse?.toDomain(),
    sha = this.sha,
    user = this.user?.toDomain()
)

fun GithubPRResultCommentsResponse.toDomain() = GithubPRResultCommentsDomain(
    href = this.href
)

fun GithubPRResultCommitsResponse.toDomain() = GithubPRResultCommitsDomain(
    href = this.href
)

fun GithubPRResultHeadResponse.toDomain() = GithubPRResultHeadDomain(
    label = this.label,
    ref = this.ref,
    repo = this.repo?.toDomain(),
    sha = this.sha,
    user = this.user?.toDomain()
)

fun GithubPRResultHtmlResponse.toDomain() = GithubPRResultHtmlDomain(
    href = this.href
)

fun GithubPRResultIssueResponse.toDomain() = GithubPRResultIssueDomain(
    href = this.href
)

fun GithubPRResultItemResponse.toDomain() = GithubPRResultItemDomain(
    activeLockReason = this.activeLockReason,
    assignee = this.assignee,
    assignees = this.assignees,
    authorAssociation = this.authorAssociation,
    autoMerge = this.autoMerge,
    githubPRResultBaseDomain = this.githubPRResultBaseResponse?.toDomain(),
    body = this.body,
    closedAt = this.closedAt,
    commentsUrl = this.commentsUrl,
    commitsUrl = this.commitsUrl,
    createdAt = this.createdAt,
    diffUrl = this.diffUrl,
    draft = this.draft,
    githubPRResultHeadDomain = this.githubPRResultHeadResponse?.toDomain(),
    htmlUrl = this.htmlUrl,
    id = this.id,
    issueUrl = this.issueUrl,
    githubPRResultLabelDomain = this.githubPRResultLabelResponse?.map { it.toDomain() },
    githubPRResultLinksDomain = this.githubPRResultLinksResponse?.toDomain(),
    locked = this.locked,
    mergeCommitSha = this.mergeCommitSha,
    mergedAt = this.mergedAt,
    milestone = this.milestone,
    nodeId = this.nodeId,
    number = this.number,
    patchUrl = this.patchUrl,
    requestedReviewers = this.requestedReviewers,
    requestedTeams = this.requestedTeams,
    reviewCommentUrl = this.reviewCommentUrl,
    reviewCommentsUrl = this.reviewCommentsUrl,
    state = this.state,
    statusesUrl = this.statusesUrl,
    title = this.title,
    updatedAt = this.updatedAt,
    url = this.url,
    user = this.user?.toDomain()
)

fun GithubPRResultLabelResponse.toDomain() = GithubPRResultLabelDomain(
    color = this.color,
    default = this.default,
    description = this.description,
    id = this.id,
    name = this.name,
    nodeId = this.nodeId,
    url = this.url
)

fun GithubPRResultLicenseResponse.toDomain() = GithubPRResultLicenseDomain(
    key = this.key,
    name = this.name,
    nodeId = this.nodeId,
    spdxId = this.spdxId,
    url = this.url
)

fun GithubPRResultLinksResponse.toDomain() = GithubPRResultLinksDomain(
    githubPRResultCommentsDomain = this.githubPRResultCommentsResponse?.toDomain(),
    githubPRResultCommitsDomain = this.githubPRResultCommitsResponse?.toDomain(),
    githubPRResultHtmlDomain = this.githubPRResultHtmlResponse?.toDomain(),
    githubPRResultIssueDomain = this.githubPRResultIssueResponse?.toDomain(),
    githubPRResultReviewCommentDomain = this.githubPRResultReviewCommentResponse?.toDomain(),
    githubPRResultReviewCommentsDomain = this.githubPRResultReviewCommentsResponse?.toDomain(),
    githubPRResultSelfDomain = this.githubPRResultSelfResponse?.toDomain(),
    githubPRResultStatusesDomain = this.githubPRResultStatusesResponse?.toDomain()
)

fun GithubPRResultOwnerResponse.toDomain() = GithubPRResultOwnerDomain(
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

fun GithubPRResultRepoResponse.toDomain() = GithubPRResultRepoDomain(
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
    githubPRResultLicenseDomain = this.githubPRResultLicenseResponse?.toDomain(),
    mergesUrl = this.mergesUrl,
    milestonesUrl = this.milestonesUrl,
    mirrorUrl = this.mirrorUrl,
    name = this.name,
    nodeId = this.nodeId,
    notificationsUrl = this.notificationsUrl,
    openIssues = this.openIssues,
    openIssuesCount = this.openIssuesCount,
    githubPRResultOwnerDomain = this.githubPRResultOwnerResponse?.toDomain(),
    `private` = this.`private`,
    pullsUrl = this.pullsUrl,
    pushedAt = this.pushedAt,
    releasesUrl = this.releasesUrl,
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

fun GithubPRResultRepoXResponse.toDomain() = GithubPRResultRepoXDomain(
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
    githubPRResultLicenseDomain = this.githubPRResultLicenseResponse?.toDomain(),
    mergesUrl = this.mergesUrl,
    milestonesUrl = this.milestonesUrl,
    mirrorUrl = this.mirrorUrl,
    name = this.name,
    nodeId = this.nodeId,
    notificationsUrl = this.notificationsUrl,
    openIssues = this.openIssues,
    openIssuesCount = this.openIssuesCount,
    githubPRResultOwnerDomain = this.githubPRResultOwnerResponse?.toDomain(),
    `private` = this.`private`,
    pullsUrl = this.pullsUrl,
    pushedAt = this.pushedAt,
    releasesUrl = this.releasesUrl,
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

fun GithubPRResultReviewCommentResponse.toDomain() = GithubPRResultReviewCommentDomain(
    href = this.href
)

fun GithubPRResultReviewCommentsResponse.toDomain() = GithubPRResultReviewCommentsDomain(
    href = this.href
)

fun GithubPRResultSelfResponse.toDomain() = GithubPRResultSelfDomain(
    href = this.href
)

fun GithubPRResultStatusesResponse.toDomain() = GithubPRResultStatusesDomain(
    href = this.href
)

fun GithubPRResultUserXXResponse.toDomain() = GithubPRResultUserXXDomain(
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