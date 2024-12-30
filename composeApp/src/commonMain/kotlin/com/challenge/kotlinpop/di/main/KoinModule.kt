package com.challenge.kotlinpop.di.main

import com.challenge.kotlinpop.di.data.dataModule
import com.challenge.kotlinpop.di.network.networkModule
import com.challenge.kotlinpop.di.presentation.presentationModule
import com.challenge.kotlinpop.di.usecase.useCaseRemoteModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)
        modules(
            presentationModule,
            dataModule,
            networkModule,
            useCaseRemoteModule
        )
    }
}