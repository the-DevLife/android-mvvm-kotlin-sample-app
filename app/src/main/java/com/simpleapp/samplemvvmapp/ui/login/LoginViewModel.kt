package com.simpleapp.samplemvvmapp.ui.login

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.simpleapp.samplemvvmapp.data.model.login.LoginResponse
import com.simpleapp.samplemvvmapp.data.model.login.User
import com.simpleapp.samplemvvmapp.data.repository.LoginRepository
import com.simpleapp.samplemvvmapp.utils.ResponseHandler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel(private val loginRepository: LoginRepository): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var loginResponse = MutableLiveData<ResponseHandler<LoginResponse>>()

    fun validateCredentials(userName: String, password: String){
//        use below code for network calls

        loginResponse.postValue(ResponseHandler.loading(null))
        Handler().postDelayed({
            loginResponse.postValue(ResponseHandler.success(null))
        }, 2000)
    }

    /*fun validateCredentials(userName: String, password: String) {
        loginResponse.postValue(ResponseHandler.loading(null))
        compositeDisposable.add(
            loginRepository.validateCredentialsApiCall(
                username = userName, password = password
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    loginResponse.postValue(ResponseHandler.success(response))
                }, { t ->
                    if (t is HttpException) {
                        val body =  t.response().errorBody()
                        val adapter: TypeAdapter<LoginResponse> =
                            Gson().getAdapter(LoginResponse::class.java)
                        try {
                            val errorParser = adapter.fromJson(body!!.string())
                            loginResponse.postValue(ResponseHandler.error(errorParser))
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    } else {
                        loginResponse.postValue(ResponseHandler.exception(t.message))
                    }
                })
        )
    }*/

    fun getResponse() : MutableLiveData<ResponseHandler<LoginResponse>> {
        return loginResponse
    }

    fun doSaveUserCredentials(user: User){
        loginRepository.doSaveUser(user)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}