package com.challenge.kotlinpop.features.home.action

sealed interface HomeAction {
    data object Idle : HomeAction
    data object RequestData: HomeAction
}