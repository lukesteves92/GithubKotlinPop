package br.com.challenge.kotlinpop.core.navigation

import kotlinx.serialization.Serializable

sealed interface HomeRoutes {

    @Serializable
    data object Home : HomeRoutes

    @Serializable
    data object Details : HomeRoutes

}