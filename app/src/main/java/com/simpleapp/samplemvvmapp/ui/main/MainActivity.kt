package com.simpleapp.samplemvvmapp.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.simpleapp.samplemvvmapp.R
import com.simpleapp.samplemvvmapp.databinding.ActivityMainBinding
import com.simpleapp.samplemvvmapp.ui.base.BaseActivity
import com.simpleapp.samplemvvmapp.ui.mainfragment.SimpleFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val mainViewModel : MainViewModel by viewModel()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
        setUp()
    }

    override fun setUp() {
        val fm = supportFragmentManager
        fm.beginTransaction()
            .add(R.id.main_container, SimpleFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        val count = fm.backStackEntryCount
        if (count == 1){
            finish()
        }
        super.onBackPressed()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }
}