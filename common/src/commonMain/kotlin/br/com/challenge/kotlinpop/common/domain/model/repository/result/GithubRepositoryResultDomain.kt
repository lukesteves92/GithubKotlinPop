package br.com.challenge.kotlinpop.common.domain.model.repository.result

import br.com.challenge.kotlinpop.common.domain.model.repository.item.GithubRepositoryItemDomain

data class GithubRepositoryResultDomain(
    val incompleteResults: Boolean? = null,
    val githubRepositoryItemDomain: List<GithubRepositoryItemDomain>? = null,
    val totalCount: Int? = null
)