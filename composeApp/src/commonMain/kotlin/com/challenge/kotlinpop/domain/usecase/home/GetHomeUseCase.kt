package com.challenge.kotlinpop.domain.usecase.home

import com.challenge.kotlinpop.domain.repository.HomeRepository
import com.challenge.kotlinpop.domain.usecase.main.UseCase

class GetHomeUseCase(repository: HomeRepository) :
    UseCase<CreateUser, UserDomain>({ createUserRequest ->
        repository.fetchCreateUserFlow(createUserRequest.toRequest())
    })