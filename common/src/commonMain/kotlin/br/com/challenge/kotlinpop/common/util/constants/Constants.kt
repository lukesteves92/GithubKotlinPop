package br.com.challenge.kotlinpop.common.util.constants

object Constants {

    // Contains default text-related constants used throughout the application.
    object Text {
        const val EMPTY_STRING_DEFAULT = ""
        const val EMPTY_SPACE_DEFAULT = " "
        const val CURSOR_DEFAULT = "|"
    }

    // Contains numeric constants used for various purposes such as animations and limits.
    object Numbers {
        const val KEY_NUMBER_ZERO = 0
        const val KEY_NUMBER_ONE = 1
        const val KEY_NUMBER_TWO = 2
        const val KEY_NUMBER_THREE = 3
        const val KEY_NUMBER_FOUR = 4
        const val KEY_NUMBER_FIVE = 5
        const val KEY_NUMBER_EIGHT = 8
        const val KEY_DURATION_ANIMATION_MIN = 500
        const val KEY_TOAST_DURATION_MAX: Long = 5000
    }


    // Contains constants for API responses and error messages.
    object Api {
        const val KEY_API_CODE_SUCCESS_MIN = 200
        const val KEY_API_CODE_SUCCESS_MAX = 299
        const val KEY_API_ERROR_MESSAGE_DEFAULT = "Não conseguimos carregar suas informações"
        const val KEY_INTERNET_ERROR_MESSAGE_DEFAULT = "Parece que você está sem internet"
    }

    // Contains constants for Design keys
    object DesignTokens {
        // FontWeight
        const val KEY_LIGHT: Int = 300
        const val KEY_BOLD: Int = 700

        // Opacity
        const val KEY_KOTLIN_POP_OPACITY_08_PERCENT: Float = 0.08f
        const val KEY_KOTLIN_POP_OPACITY_09_PERCENT: Float = 0.09f
        const val KEY_KOTLIN_POP_OPACITY_10_PERCENT: Float = 0.1f

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
    }
}