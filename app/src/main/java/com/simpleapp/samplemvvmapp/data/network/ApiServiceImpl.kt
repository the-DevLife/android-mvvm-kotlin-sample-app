package com.simpleapp.samplemvvmapp.data.network

import com.simpleapp.samplemvvmapp.data.model.login.LoginResponse
import io.reactivex.Single

class ApiServiceImpl : ApiService {
    override fun validateCredentialsApiCall(
        username: String,
        password: String
    ): Single<LoginResponse> {
        return ApiClient.instance.validateCredentialsApiCall(username, password)
    }
}