package com.novacenter.app.data.network

import com.novacenter.app.data.model.*
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // 🔐 Autenticación
    @POST("api/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("api/auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<Boolean>

    // 🔒 Recuperación de contraseña
    @POST("api/auth/solicitar-recuperacion")
    suspend fun solicitarRecuperacion(@Body req: RecuperarRequest): Response<String>

    @POST("api/auth/restablecer")
    suspend fun restablecerPassword(@Body req: RestablecerRequest): Response<String>

    // 📅 Turnos
    @GET("api/turnos")
    suspend fun getTurnos(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10
    ): Response<List<Turno>>

    @GET("api/turnos/{id}")
    suspend fun getTurnoById(@Path("id") id: Int): Response<Turno>

    @POST("api/turnos")
    suspend fun createTurno(@Body turno: TurnoDTO): Response<Turno>

    @PUT("api/turnos/{id}")
    suspend fun updateTurno(@Path("id") id: Int, @Body turno: TurnoDTO): Response<Boolean>

    @DELETE("api/turnos/{id}")
    suspend fun deleteTurno(@Path("id") id: Int): Response<Boolean>

    // 👤 Usuarios
    @GET("api/usuarios/{id}")
    suspend fun getUsuario(@Path("id") id: Int): Response<Usuario>

    // 📷 Código QR
    @GET("api/qr/generar/{idTurno}")
    suspend fun generarQR(@Path("idTurno") idTurno: Int): Response<ResponseBody>

    @GET("api/qr/validar/{token}")
    suspend fun validarTokenQR(@Path("token") token: String): Response<String>
}