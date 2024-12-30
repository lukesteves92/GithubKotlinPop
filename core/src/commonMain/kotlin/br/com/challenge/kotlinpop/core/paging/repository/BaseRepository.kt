package br.com.challenge.kotlinpop.core.paging.repository

import br.com.challenge.kotlinpop.core.paging.model.PaginationItems

abstract class BaseRepository {
    fun <T> paginateData(result: List<T>, page: Int, total: Long): PaginationItems<T> {
        return PaginationItems(total = total, page = page, items = result)
    }
}