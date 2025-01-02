package br.com.challenge.kotlinpop.common.domain.model.pr.links

import br.com.challenge.kotlinpop.common.domain.model.pr.review.GithubPRResultReviewCommentDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.reviews.GithubPRResultReviewCommentsDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.self.GithubPRResultSelfDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.status.GithubPRResultStatusesDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.comments.GithubPRResultCommentsDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.commits.GithubPRResultCommitsDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.html.GithubPRResultHtmlDomain
import br.com.challenge.kotlinpop.common.domain.model.pr.issue.GithubPRResultIssueDomain

data class GithubPRResultLinksDomain(
    val githubPRResultCommentsDomain: GithubPRResultCommentsDomain? = null,
    val githubPRResultCommitsDomain: GithubPRResultCommitsDomain? = null,
    val githubPRResultHtmlDomain: GithubPRResultHtmlDomain? = null,
    val githubPRResultIssueDomain: GithubPRResultIssueDomain? = null,
    val githubPRResultReviewCommentDomain: GithubPRResultReviewCommentDomain? = null,
    val githubPRResultReviewCommentsDomain: GithubPRResultReviewCommentsDomain? = null,
    val githubPRResultSelfDomain: GithubPRResultSelfDomain? = null,
    val githubPRResultStatusesDomain: GithubPRResultStatusesDomain? = null
)