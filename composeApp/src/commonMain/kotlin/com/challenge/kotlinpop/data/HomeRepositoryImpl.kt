package com.challenge.kotlinpop.data

import br.com.challenge.kotlinpop.core.wrapper.main.RequestWrapper
import com.challenge.kotlinpop.domain.repository.HomeRepository
import io.ktor.client.HttpClient

class HomeRepositoryImpl(
    private val httpClient: HttpClient,
    private val wrapper: RequestWrapper
): HomeRepository {

}