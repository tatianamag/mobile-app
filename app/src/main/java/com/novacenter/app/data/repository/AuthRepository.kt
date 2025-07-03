package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.network.RetrofitInstance

class AuthRepository (private val context: Context)  {

    private val authService = RetrofitInstance.authService

    suspend fun login(username: String, password: String): LoginResponse {
        val request = LoginRequest(username, password)
        val response = authService.login(request)

        // Guardar token en SharedPreferences
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("TOKEN", response.token).apply()

        return response
    }
}