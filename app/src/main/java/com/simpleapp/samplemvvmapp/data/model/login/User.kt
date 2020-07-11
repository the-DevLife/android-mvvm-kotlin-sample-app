package com.simpleapp.samplemvvmapp.data.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("id")
    val id : String,

    @Expose
    @SerializedName("full_name")
    val fullName : String,

    @Expose
    @SerializedName("username")
    val username : String,

    @Expose
    @SerializedName("phone")
    val phone : String,

    @Expose
    @SerializedName("email")
    val email : String,

    @Expose
    @SerializedName("type")
    val type : Int,

    @Expose
    @SerializedName("token")
    val token : String
)