package com.simpleapp.samplemvvmapp.data.network

class ApiHelper(private val apiService: ApiService) {

    fun validateCredentialsApiCall(
        username: String,
        password: String
    ) = apiService.validateCredentialsApiCall(username, password)
}