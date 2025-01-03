package com.challenge.kotlinpop.features.details.action

sealed interface DetailsAction {
    data object Idle : DetailsAction
    data object RequestData: DetailsAction
}