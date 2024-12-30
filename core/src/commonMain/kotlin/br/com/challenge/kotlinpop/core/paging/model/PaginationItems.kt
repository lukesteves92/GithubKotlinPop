package br.com.challenge.kotlinpop.core.paging.model

data class PaginationItems<T>(
    val items: List<T>,
    val page: Int,
    val total: Long
)
