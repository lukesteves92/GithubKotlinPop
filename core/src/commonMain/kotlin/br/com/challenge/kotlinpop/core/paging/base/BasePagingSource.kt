package br.com.challenge.kotlinpop.core.paging.base

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import br.com.challenge.kotlinpop.core.paging.model.PaginationItems

abstract class BasePagingSource<Value : Any> : PagingSource<Int, Value>() {

    protected abstract suspend fun fetchData(page: Int, limit: Int): PaginationItems<Value>

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, Value> {
        val currentPage = params.key ?: 1
        val limit = params.loadSize
        return try {
            val response = fetchData(currentPage, limit)
            PagingSourceLoadResultPage(
                data = response.items,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey =  (currentPage + 1).takeIf { response.items.lastIndex >= currentPage }
            )

        } catch (e: Exception) {
            PagingSourceLoadResultError(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition
    }
}