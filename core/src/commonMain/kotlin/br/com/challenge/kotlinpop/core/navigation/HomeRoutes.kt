package br.com.challenge.kotlinpop.core.navigation

import kotlinx.serialization.Serializable

sealed interface HomeRoutes {

    @Serializable
    data object Home : HomeRoutes

    @Serializable
    data class Details(
        val creator: String,
        val repo: String
    ) : HomeRoutes
}