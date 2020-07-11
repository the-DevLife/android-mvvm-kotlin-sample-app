package com.simpleapp.samplemvvmapp.data.preference

interface SharedPrefManagerHelper {
    fun setLogin(token: String)
    fun getLoginStatus(): Boolean
    fun getToken(): String
    fun clearData()
}