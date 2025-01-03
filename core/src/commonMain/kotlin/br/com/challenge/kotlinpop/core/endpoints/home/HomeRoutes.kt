package br.com.challenge.kotlinpop.core.endpoints.home

enum class HomeRoutes(val path: String) {
    GetRepositories("/search/repositories");
    override fun toString(): String = path
}