package com.novacenter.app.data.network

import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/login")
    @Headers("Content-Type: application/json")

    suspend fun login(@Body request: LoginRequest): LoginResponse
}


