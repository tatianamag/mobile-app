package com.novacenter.app.data.repository

import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.network.RetrofitInstance
import retrofit2.Response

class AuthRepository {
    private val authService = RetrofitInstance.authService

    suspend fun login(username: String, password: String): Response<LoginResponse> {
        val request = LoginRequest(username, password)
        return authService.login(request)
    }
}