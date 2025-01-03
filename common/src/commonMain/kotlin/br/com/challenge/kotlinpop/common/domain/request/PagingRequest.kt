package br.com.challenge.kotlinpop.common.domain.request

import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_LANGUAGE
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_LANGUAGE_ID
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_LIMIT
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_PAGE
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_PAGE_ID
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_SORT
import br.com.challenge.kotlinpop.common.util.constants.Constants.Paging.KEY_PAGING_DEFAULT_SORT_ID

data class PagingRequest(
    val page: Int = KEY_PAGING_DEFAULT_PAGE,
    val limit: Int = KEY_PAGING_DEFAULT_LIMIT,
    val language: String = KEY_PAGING_DEFAULT_LANGUAGE,
    val sort: String = KEY_PAGING_DEFAULT_SORT,
    val languageId: String = KEY_PAGING_DEFAULT_LANGUAGE_ID,
    val sortId: String = KEY_PAGING_DEFAULT_SORT_ID,
    val pageId: String = KEY_PAGING_DEFAULT_PAGE_ID,
)