package com.simpleapp.samplemvvmapp.data.preference

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.simpleapp.samplemvvmapp.SimpleApp

class SharedPrefManager(app : SimpleApp) : SharedPrefManagerHelper {
    private val TOKEN = "token"
    private val LOGIN_STATUS = "loginStatus"

    private var prefernce: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    override fun setLogin(token: String) {
        val editor = prefernce.edit()
        editor.putString(TOKEN, token)
        editor.putBoolean(LOGIN_STATUS, true)
        editor.apply()
    }

    override fun getLoginStatus(): Boolean {
        return prefernce.getBoolean(LOGIN_STATUS, false)
    }

    override fun getToken(): String {
        return prefernce.getString(TOKEN, "")?:""
    }

    override fun clearData() {
        val editor = prefernce.edit()
        editor.clear()
        editor.apply()
    }
}