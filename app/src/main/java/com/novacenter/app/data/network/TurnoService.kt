package com.novacenter.app.data.network

import com.novacenter.app.data.model.Turno
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface TurnoService {
    @GET("turnos")
    suspend fun obtenerTurnos(): List<Turno>

    @POST("turnos")
    suspend fun crearTurno(@Body turno: Turno): Turno
}
