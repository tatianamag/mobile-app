package com.novacenter.app.data.network

import com.novacenter.app.data.model.Usuario
import retrofit2.Response
import retrofit2.http.*

interface UsuarioService {

    @GET("api/usuarios")
    suspend fun getUsuarios(): Response<List<Usuario>>

    @GET("api/usuarios/{id}")
    suspend fun getUsuario(@Path("id") id: Int): Response<Usuario>

    @POST("api/usuarios")
    suspend fun addUsuario(@Body usuario: Usuario): Response<Usuario>

    @PUT("api/usuarios/{id}")
    suspend fun updateUsuario(@Path("id") id: Int, @Body usuario: Usuario): Response<Usuario>

    @DELETE("api/usuarios/{id}")
    suspend fun deleteUsuario(@Path("id") id: Int): Response<Unit>
}