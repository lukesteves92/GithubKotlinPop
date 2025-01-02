package com.challenge.kotlinpop.di.usecase

import com.challenge.kotlinpop.domain.usecase.home.GetHomeUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseRemoteModule = module {
    // Home
    factoryOf(::GetHomeUseCase)
}