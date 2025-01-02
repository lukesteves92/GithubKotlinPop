package br.com.challenge.kotlinpop.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.challenge.kotlinpop.common.api.ApiResult
import br.com.challenge.kotlinpop.common.error.network.NetworkApiError
import br.com.challenge.kotlinpop.common.util.constants.Constants.Numbers.KEY_NUMBER_ONE
import coil3.network.HttpException
import kotlinx.io.IOException

open class BasePagingSource<Value : Any>(private val fetchData: suspend (page: Int, pageSize: Int) -> ApiResult<List<Value>, NetworkApiError>) : PagingSource<Int, Value>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> =
        (params.key ?: KEY_NUMBER_ONE).let { resultPage ->
            try {
                fetchData(resultPage, params.loadSize)
                    .run {
                        when (this) {
                            is ApiResult.Success -> {
                                LoadResult.Page(
                                    data = data,
                                    prevKey = resultPage.takeIf { it > KEY_NUMBER_ONE }?.dec(),
                                    nextKey = resultPage.takeIf { data.size >= params.loadSize }?.inc()
                                )
                            }
                            is Error -> LoadResult.Error(this)
                            else -> LoadResult.Error(IllegalStateException("$this type of [Result] is not allowed here"))
                        }
                    }
            } catch (exception: IOException) {
                exception.printStackTrace()
                return LoadResult.Error(exception)
            } catch (exception: HttpException) {
                exception.printStackTrace()
                return LoadResult.Error(exception)
            }
        }
    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(KEY_NUMBER_ONE)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(KEY_NUMBER_ONE)
        }
    }
}