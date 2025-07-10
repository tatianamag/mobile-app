package com.novacenter.app.data.network

import com.novacenter.app.data.model.Medico
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MedicoService {

    @GET("Medico/listado")
    suspend fun obtenerMedicos(): Response<List<Medico>>

    @GET("Medico/detalle/{id}")
    suspend fun obtenerDetalleMedico(@Path("id") id: Int): Response<Medico>
}
