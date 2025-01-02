package com.challenge.kotlinpop.di.data

import com.challenge.kotlinpop.data.HomeRepositoryImpl
import com.challenge.kotlinpop.domain.repository.HomeRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    // Home
    factoryOf(::HomeRepositoryImpl).bind(HomeRepository::class)
}