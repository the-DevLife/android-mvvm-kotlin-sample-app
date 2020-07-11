package com.simpleapp.samplemvvmapp.data.repository

import com.simpleapp.samplemvvmapp.data.model.login.LoginResponse
import com.simpleapp.samplemvvmapp.data.model.login.User
import com.simpleapp.samplemvvmapp.data.network.ApiHelper
import com.simpleapp.samplemvvmapp.data.preference.SharedPrefManager
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginRepository(private val apiHelper: ApiHelper) : KoinComponent {

    private val preference : SharedPrefManager by inject()

    fun validateCredentialsApiCall(
        username: String,
        password: String
    ): Single<LoginResponse> {
        return apiHelper.validateCredentialsApiCall(username, password)
    }

    fun doSaveUser(user: User) {
        preference.setLogin(token = user.token)
    }
}