package com.simpleapp.samplemvvmapp.ui.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.simpleapp.samplemvvmapp.R
import com.simpleapp.samplemvvmapp.data.preference.SharedPrefManager
import com.simpleapp.samplemvvmapp.databinding.ActivityLoginBinding
import com.simpleapp.samplemvvmapp.ui.base.BaseActivity
import com.simpleapp.samplemvvmapp.utils.ActivityMediator
import com.simpleapp.samplemvvmapp.utils.hide
import com.simpleapp.samplemvvmapp.utils.show
import com.simpleapp.samplemvvmapp.utils.showInfoToast
import com.simpleapp.simplemvvmapp.utils.Status
import kotlinx.android.synthetic.main.view_progress_bar.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val loginViewModel : LoginViewModel by viewModel()
    lateinit var binding: ActivityLoginBinding
    private val preference: SharedPrefManager by inject()

    override fun onResume() {
        super.onResume()
        supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
        if (preference.getLoginStatus()){
            ActivityMediator.startMainActivity(this)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        setUp()
    }

    override fun setUp() {
        binding.loginBtn.setOnClickListener {
            when{
                binding.etUsername.text.toString().isNullOrEmpty() -> binding.tfUsername.error = getString(R.string.error_username)
                binding.etPassword.text.toString().isNullOrEmpty() -> binding.tfPassword.error = getString(R.string.error_password)
                else -> {
                    listenResponse()

                    loginViewModel.validateCredentials(
                        userName = binding.etUsername.text.toString().trim(),
                        password = binding.etPassword.text.toString().trim()
                    )
                }
            }
        }
    }

    private fun listenResponse() {
        loginViewModel.getResponse().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    hideProgress()

                    ActivityMediator.startMainActivity(this) // clear this code

                    it.data?.let { response ->
                        // Do Server Response Handling here
                    }
                }
                Status.LOADING -> {
                    showProgress()
                }
                Status.ERROR -> {
                    //Handle Error
                    hideProgress()
                    it.data?.let { response ->
                    }
                }
                Status.EXCEPTION -> {
                    hideProgress()
                    binding.etUsername.showInfoToast(it.message!!)
                }
            }
        })
    }

    override fun showProgress() {
        progress_bar?.show()
    }

    override fun hideProgress() {
        progress_bar?.hide()
    }
}