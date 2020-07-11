package com.simpleapp.samplemvvmapp.data.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @Expose
    @SerializedName("statusCode")
    val statusCode : Int,

    @Expose
    @SerializedName("message")
    val message : String,

    @Expose
    @SerializedName("data")
    val user : User,

    @Expose
    @SerializedName("error")
    val error : String
)