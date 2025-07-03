package com.novacenter.app.data.network

import com.novacenter.app.data.model.Turno
import com.novacenter.app.data.model.TurnoDTO
import retrofit2.Response
import retrofit2.http.*

interface TurnoService {

    @GET("api/turnos")
    suspend fun obtenerTurnos(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10
    ): Response<List<Turno>>

    @GET("api/turnos/{id}")
    suspend fun obtenerTurnoPorId(@Path("id") id: Int): Response<Turno>

    @POST("api/turnos")
    suspend fun crearTurno(@Body turno: TurnoDTO): Response<Turno>

    @PUT("api/turnos/{id}")
    suspend fun actualizarTurno(
        @Path("id") id: Int,
        @Body turno: TurnoDTO
    ): Response<Unit>

    @DELETE("api/turnos/{id}")
    suspend fun eliminarTurno(@Path("id") id: Int): Response<Unit>
}