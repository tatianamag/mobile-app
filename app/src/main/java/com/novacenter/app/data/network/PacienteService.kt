package com.novacenter.app.data.network

import com.novacenter.app.data.model.Persona
import com.novacenter.app.data.model.PacienteUpdateRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.Response

interface PacienteService {

    @GET("Paciente/detalle/{id}")
    suspend fun obtenerDetallePaciente(@Path("id") id: Int): Response<Persona>

    @POST("Paciente/editar/{id}")
    suspend fun editarPaciente(
        @Path("id") id: Int,
        @Body datos: PacienteUpdateRequest
    ): Response<Unit>
}
