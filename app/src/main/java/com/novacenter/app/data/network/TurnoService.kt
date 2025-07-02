package com.novacenter.app.data.network

import com.novacenter.app.model.Turno
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TurnoService {
    @GET("turnos")
    suspend fun obtenerTurnos(): List<Turno>

    @POST("turnos")
    suspend fun crearTurno(@Body turno: Turno): Response<Unit>
}
