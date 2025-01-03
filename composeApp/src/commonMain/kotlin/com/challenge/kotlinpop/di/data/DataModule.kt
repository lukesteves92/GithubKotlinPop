package com.challenge.kotlinpop.di.data

import com.challenge.kotlinpop.data.repository.details.DetailsRepositoryImpl
import com.challenge.kotlinpop.data.repository.home.HomeRepositoryImpl
import com.challenge.kotlinpop.domain.repository.details.DetailsRepository
import com.challenge.kotlinpop.domain.repository.home.HomeRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    // Home
    factoryOf(::HomeRepositoryImpl).bind(HomeRepository::class)

    // Details
    factoryOf(::DetailsRepositoryImpl).bind(DetailsRepository::class)
}