package com.simpleapp.samplemvvmapp.data.network

import com.simpleapp.samplemvvmapp.data.preference.SharedPrefManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient : KoinComponent {

    private val preferenceManager : SharedPrefManager by inject()

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor{ chain ->
                val original = chain.request()

                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
                    .build()

                val requestBuilder =  if (original.header("No-Authentication") == null){
                    original.newBuilder()
                        .method(original.method(), original.body())
                        .addHeader("Authorization", "Bearer ${preferenceManager.getToken()}")
                        .url(url)
                } else{
                    original.newBuilder()
                        .method(original.method(), original.body())
                        .url(url)
                }

                val request = requestBuilder.build()
                    chain.proceed(request)
            }.build()

    val instance : ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiEndPoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(ApiService::class.java)
    }
}