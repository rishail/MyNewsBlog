package com.example.mynewsblog.data

import com.example.mynewsblog.data.api.ApiService
import com.example.mynewsblog.data.model.LoginRequestModel
import com.example.mynewsblog.data.model.LoginResponseModel
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(loginRequestModel: LoginRequestModel): LoginResponseModel {

        return apiService.login(loginRequestModel)
    }

}


