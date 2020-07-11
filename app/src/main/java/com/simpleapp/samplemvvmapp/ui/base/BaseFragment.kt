package com.simpleapp.samplemvvmapp.ui.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected abstract fun setUp()
    protected abstract fun showProgress()
    protected abstract fun hideProgress()
}