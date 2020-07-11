package com.simpleapp.samplemvvmapp.data.network

import com.simpleapp.samplemvvmapp.data.model.login.LoginResponse
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {
    @Headers("No-Authentication:true")
    @FormUrlEncoded
    @POST(ApiEndPoints.LOGIN_URL)
    fun validateCredentialsApiCall(
        @Field("username") username: String,
        @Field("password") password: String
    ): Single<LoginResponse>
}