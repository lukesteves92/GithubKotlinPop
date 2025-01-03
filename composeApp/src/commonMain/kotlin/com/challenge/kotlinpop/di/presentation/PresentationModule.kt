package com.challenge.kotlinpop.di.presentation

import com.challenge.kotlinpop.features.details.viewmodel.DetailsViewModel
import com.challenge.kotlinpop.features.home.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    // Home
    viewModelOf(::HomeViewModel)

    // Details
    viewModelOf(::DetailsViewModel)
}