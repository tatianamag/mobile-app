package com.novacenter.app.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.novacenter.app.data.api.ApiService // 👈 IMPORTANTE

object RetrofitClient {

    private const val BASE_URL = "http://localhost:5000" // o la que uses

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java) // 👈 ESTA LÍNEA NO DEBE DAR ERROR
    }
}
