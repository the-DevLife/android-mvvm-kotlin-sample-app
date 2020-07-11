package com.simpleapp.samplemvvmapp.ui.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    protected abstract fun setUp()
    protected abstract fun showProgress()
    protected abstract fun hideProgress()
}