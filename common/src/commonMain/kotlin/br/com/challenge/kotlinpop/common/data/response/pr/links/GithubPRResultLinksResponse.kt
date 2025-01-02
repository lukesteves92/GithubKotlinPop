package br.com.challenge.kotlinpop.common.data.response.pr.links

import br.com.challenge.kotlinpop.common.data.response.pr.review.GithubPRResultReviewCommentResponse
import br.com.challenge.kotlinpop.common.data.response.pr.reviews.GithubPRResultReviewCommentsResponse
import br.com.challenge.kotlinpop.common.data.response.pr.self.GithubPRResultSelfResponse
import br.com.challenge.kotlinpop.common.data.response.pr.status.GithubPRResultStatusesResponse
import br.com.challenge.kotlinpop.common.data.response.pr.comments.GithubPRResultCommentsResponse
import br.com.challenge.kotlinpop.common.data.response.pr.commits.GithubPRResultCommitsResponse
import br.com.challenge.kotlinpop.common.data.response.pr.html.GithubPRResultHtmlResponse
import br.com.challenge.kotlinpop.common.data.response.pr.issue.GithubPRResultIssueResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPRResultLinksResponse(
    @SerialName("comments")
    val githubPRResultCommentsResponse: GithubPRResultCommentsResponse? = null,
    @SerialName("commits")
    val githubPRResultCommitsResponse: GithubPRResultCommitsResponse? = null,
    @SerialName("html")
    val githubPRResultHtmlResponse: GithubPRResultHtmlResponse? = null,
    @SerialName("issue")
    val githubPRResultIssueResponse: GithubPRResultIssueResponse? = null,
    @SerialName("review_comment")
    val githubPRResultReviewCommentResponse: GithubPRResultReviewCommentResponse? = null,
    @SerialName("review_comments")
    val githubPRResultReviewCommentsResponse: GithubPRResultReviewCommentsResponse? = null,
    @SerialName("self")
    val githubPRResultSelfResponse: GithubPRResultSelfResponse? = null,
    @SerialName("statuses")
    val githubPRResultStatusesResponse: GithubPRResultStatusesResponse? = null
)