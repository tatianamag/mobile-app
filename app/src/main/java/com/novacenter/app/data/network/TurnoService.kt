package com.novacenter.app.data.network

import com.novacenter.app.data.model.Turno
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface TurnoService {
    @GET("turnos")
    suspend fun obtenerTurnos(
        @retrofit2.http.Query("page") page: Int = 1,
        @retrofit2.http.Query("pageSize") pageSize: Int = 10
    ): List<Turno>

    @GET("turnos/{id}")
    suspend fun obtenerTurnoPorId(@retrofit2.http.Path("id") id: Int): Turno

    @POST("turnos")
    suspend fun crearTurno(@Body turno: Turno): Turno

    @retrofit2.http.PUT("turnos/{id}")
    suspend fun actualizarTurno(
        @retrofit2.http.Path("id") id: Int,
        @Body turno: Turno
    ): retrofit2.Response<Unit>

    @retrofit2.http.DELETE("turnos/{id}")
    suspend fun eliminarTurno(@retrofit2.http.Path("id") id: Int): retrofit2.Response<Unit>
}
