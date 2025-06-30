package com.novacenter.app.data.api

import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.model.Usuario
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse

    @GET("usuarios")
    suspend fun getUsuarios(): List<Usuario>

    @GET("usuarios/{id}")
    suspend fun getUsuario(@Path("id") id: Int): Usuario

    @POST("usuarios")
    suspend fun addUsuario(@Body usuario: Usuario): Usuario

    @PUT("usuarios/{id}")
    suspend fun updateUsuario(@Path("id") id: Int, @Body usuario: Usuario): Usuario

    @DELETE("usuarios/{id}")
    suspend fun deleteUsuario(@Path("id") id: Int)
}
