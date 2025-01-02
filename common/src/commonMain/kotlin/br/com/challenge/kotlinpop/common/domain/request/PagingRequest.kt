package br.com.challenge.kotlinpop.common.domain.request

import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_LANGUAGE
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_LIMIT
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_PAGE
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_SORT

data class PagingRequest(
    val page: Int = KEY_PAGING_DEFAULT_PAGE,
    val limit: Int = KEY_PAGING_DEFAULT_LIMIT,
    val language: String = KEY_PAGING_DEFAULT_LANGUAGE,
    val sort: String = KEY_PAGING_DEFAULT_SORT
)