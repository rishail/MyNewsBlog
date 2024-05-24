package com.example.mynewsblog

import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(loginRequestModel: LoginRequestModel): LoginResponseModel {

        return apiService.login(loginRequestModel)
    }

}


