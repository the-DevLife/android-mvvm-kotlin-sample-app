package com.simpleapp.samplemvvmapp.utils

import android.content.Context
import android.content.Intent
import com.simpleapp.samplemvvmapp.ui.login.LoginActivity
import com.simpleapp.samplemvvmapp.ui.main.MainActivity

object ActivityMediator {
    fun startMainActivity(context: Context){
        context.startActivity(Intent(context, MainActivity::class.java))
    }

    fun startLoginActivity(context: Context){
        context.startActivity(Intent(context, LoginActivity::class.java))
    }

}