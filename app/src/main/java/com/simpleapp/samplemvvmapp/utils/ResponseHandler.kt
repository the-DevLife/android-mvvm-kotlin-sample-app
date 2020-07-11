package com.simpleapp.samplemvvmapp.utils

import com.simpleapp.simplemvvmapp.utils.Status

data class ResponseHandler<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): ResponseHandler<T> {
            return ResponseHandler(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?): ResponseHandler<T> {
            return ResponseHandler(Status.ERROR, data, null)
        }

        fun <T> loading(data: T?): ResponseHandler<T> {
            return ResponseHandler(Status.LOADING, null, null)
        }

        fun <T> exception(msg: String?): ResponseHandler<T> {
            return ResponseHandler(Status.EXCEPTION, null, msg)
        }

    }

}