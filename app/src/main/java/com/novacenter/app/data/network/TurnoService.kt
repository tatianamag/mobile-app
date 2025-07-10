package com.novacenter.app.data.network

import com.novacenter.app.data.model.TurnoRequest
import com.novacenter.app.data.model.TurnoDTO
import retrofit2.Response
import retrofit2.http.*

interface TurnoService {

    @POST("Turno/agregar")
    suspend fun solicitarTurno(@Body turno: TurnoRequest): Response<Unit>

    @GET("Turno/listado")
    suspend fun obtenerTurnos(): Response<List<TurnoDTO>>

    @GET("Turno/detalle/{id}")
    suspend fun obtenerTurnoDetalle(@Path("id") id: Int): Response<TurnoDTO>
}
