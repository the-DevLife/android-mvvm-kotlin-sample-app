package com.simpleapp.samplemvvmapp.ui.base

import android.view.WindowManager
import androidx.fragment.app.DialogFragment

abstract class BaseDialog : DialogFragment() {

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    protected abstract fun setUp()
    protected abstract fun showProgress()
    protected abstract fun hideProgress()

}