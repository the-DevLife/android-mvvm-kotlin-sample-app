package com.simpleapp.samplemvvmapp.utils

import android.view.View
import android.widget.Toast
import com.valdesekamdem.library.mdtoast.MDToast

fun View.showInfoToast(messageRes: String){
    MDToast.makeText(context, messageRes, Toast.LENGTH_SHORT, MDToast.TYPE_INFO).show()
}

fun View.showSuccessToast(messageRes: String){
    MDToast.makeText(context, messageRes, Toast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
}

fun View.showErrorToast(messageRes: String){
    MDToast.makeText(context, messageRes, Toast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
}

fun View.showWarningToast(messageRes: String){
    MDToast.makeText(context, messageRes, Toast.LENGTH_SHORT, MDToast.TYPE_WARNING).show()
}