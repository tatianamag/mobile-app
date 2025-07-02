package com.novacenter.app.data.network

import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse
}
