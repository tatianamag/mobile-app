package com.novacenter.app.data.repository

import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.network.RetrofitInstance

class AuthRepository {

    private val authService = RetrofitInstance.authService

    suspend fun login(username: String, password: String): LoginResponse {
        val request = LoginRequest(username, password)
        return authService.login(request)
    }
}
