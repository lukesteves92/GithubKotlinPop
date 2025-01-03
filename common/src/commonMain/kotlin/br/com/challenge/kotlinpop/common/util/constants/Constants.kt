package br.com.challenge.kotlinpop.common.util.constants

object Constants {

    // Contains default text-related constants used throughout the application.
    object Text {
        const val EMPTY_STRING_DEFAULT = ""
        const val EMPTY_STRING_REPO = "None"
    }

    // Contains numeric constants used for various purposes such as animations and limits.
    object Numbers {
        const val KEY_NUMBER_ZERO = 0
        const val KEY_NUMBER_ZERO_DOUBLE = 0.0
        const val KEY_NUMBER_ONE = 1
        const val KEY_NUMBER_TWO = 2
    }

    // Contains constants for API responses and error messages.
    object Api {
        const val KEY_API_QUERY_CREATOR = "creator"
        const val KEY_API_QUERY_REPO = "repo"
        const val KEY_API_CODE_SUCCESS_MIN = 200
        const val KEY_API_CODE_SUCCESS_MAX = 299
        const val KEY_API_ERROR_MESSAGE_DEFAULT = "We couldn't load your information"
        const val KEY_INTERNET_ERROR_MESSAGE_DEFAULT = "It looks like you're offline"
        const val KEY_NO_PULL_REQUESTS_MESSAGE_DEFAULT = "No Pull Requests are available"
    }

    // Contains constants for About Component
    object AboutComponent {
        const val KEY_KOTLIN_POP_ABOUT_SYSTEM = "Operating System"
        const val KEY_KOTLIN_POP_ABOUT_DEVICE = "Device"
        const val KEY_KOTLIN_POP_ABOUT_DENSITY = "Density"
    }

    // Contains constants for Paging
    object Paging {
        const val KEY_PAGING_DEFAULT_PAGE = 1
        const val KEY_PAGING_DEFAULT_LIMIT = 10
        const val KEY_PAGING_DEFAULT_SORT = "stars"
        const val KEY_PAGING_DEFAULT_LANGUAGE = "language:Kotlin"
        const val KEY_PAGING_DEFAULT_PAGE_ID = "page"
        const val KEY_PAGING_DEFAULT_SORT_ID = "sort"
        const val KEY_PAGING_DEFAULT_LANGUAGE_ID = "q"
    }

    // Contains constants for Image
    object Image {
        const val KEY_IMAGE_DEFAULT_URL = "https://avatars.githubusercontent.com/u/123456?v=4"
    }

    // Contains constants for Github
    object Github {
        const val KEY_GITHUB_DEFAULT_URL = "https://github.com/"
    }
}