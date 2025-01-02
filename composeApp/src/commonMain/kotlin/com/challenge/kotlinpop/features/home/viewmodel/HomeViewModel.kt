package com.challenge.kotlinpop.features.home.viewmodel

import androidx.lifecycle.ViewModel
import com.challenge.kotlinpop.domain.usecase.home.GetHomeUseCase

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
): ViewModel() {

}