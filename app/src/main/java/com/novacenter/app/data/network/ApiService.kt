package com.novacenter.app.data.network

import com.novacenter.app.data.model.*
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // Autenticación
    @POST("api/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("api/auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<Boolean>

    // Recuperación de contraseña
    @POST("api/auth/recuperar")
    suspend fun recuperar(@Body req: RecuperarRequest): Response<String>

    @POST("api/auth/restablecer")
    suspend fun restablecerPassword(@Body req: RestablecerRequest): Response<String>

    //  Turnos
    @GET("api/turno/listado")
    suspend fun obtenerTurnos(): Response<List<TurnoDTO>>

    @POST("api/turno/agregar")
    suspend fun agregarTurno(@Body turno: TurnoDTO): Response<TurnoDTO>

    @GET("api/turno/detalle/{id}")
    suspend fun obtenerDetalle(@Path("id") id: Int): Response<TurnoDTO>}