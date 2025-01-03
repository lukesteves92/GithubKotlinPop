package br.com.challenge.kotlinpop.core.endpoints.details

enum class DetailsRoutes(val path: String) {
    GetPullRequests("/repos/<creator>/<repo>/pulls");

    fun withParams(vararg params: Pair<String, String>): String {
        var updatedPath = path
        params.forEach { (key, value) ->
            updatedPath = updatedPath.replace("<$key>", value)
        }
        return updatedPath
    }

    override fun toString(): String = path
}