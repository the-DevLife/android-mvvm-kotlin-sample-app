package com.simpleapp.samplemvvmapp.di

import com.simpleapp.samplemvvmapp.SimpleApp
import com.simpleapp.samplemvvmapp.data.network.ApiHelper
import com.simpleapp.samplemvvmapp.data.network.ApiService
import com.simpleapp.samplemvvmapp.data.network.ApiServiceImpl
import com.simpleapp.samplemvvmapp.data.preference.SharedPrefManager
import com.simpleapp.samplemvvmapp.data.repository.LoginRepository
import com.simpleapp.samplemvvmapp.ui.login.LoginViewModel
import com.simpleapp.samplemvvmapp.ui.main.MainViewModel
import com.simpleapp.samplemvvmapp.ui.mainfragment.SimpleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DataModule = module {
    single { SharedPrefManager(SimpleApp.get()) }
}

val NetworkModule = module {
    factory<ApiService> { (ApiServiceImpl()) }
    factory { ApiHelper(apiService = get()) }
}

val FactoryModule = module {
    factory { LoginRepository(apiHelper = get()) }
}

val ViewModelModule = module {
    viewModel { LoginViewModel(loginRepository = get()) }
    viewModel { MainViewModel() }
    viewModel { SimpleViewModel() }
}

val AdapterModule = module {
//    factory { (activity: AppCompatActivity) -> SpinnerAdapter(activity) } //injection with parameter

//    single { DashAdapter() } // it will use single instance
//    factory { AssignmentAdapter() } // it will create new instance each time
}

val appModules = listOf(
    DataModule, NetworkModule, ViewModelModule, FactoryModule, AdapterModule
)