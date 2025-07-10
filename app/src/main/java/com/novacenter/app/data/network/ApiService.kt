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
    @POST("Turno/crear")
    suspend fun createTurno(@Body turno: TurnoRequest): Response<TurnoRequest>

    @GET("Turno/detalle/{id}")
    suspend fun getTurnoById(@Path("id") id: Int): Response<TurnoRequest>

    @GET("Turno/paciente/{idPaciente}")
    suspend fun getTurnosPaciente(@Path("idPaciente") id: Int): Response<List<TurnoDTO>>

    @GET("Turno/medico/{idMedico}")
    suspend fun getTurnosMedico(@Path("idMedico") id: Int): Response<List<TurnoDTO>>

    //  Usuarios
    //@GET("Paciente/detalle/{id}")
    //suspend fun getPaciente(@Path("id") id: Int): Response<Paciente>

}