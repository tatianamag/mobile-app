package com.novacenter.app.data.network

import com.novacenter.app.data.model.Medico
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MedicoService {

    @GET("api/medicos")
    suspend fun obtenerMedicos(): Response<List<Medico>>

    @GET("api/medicos/{id}")
    suspend fun obtenerMedicoPorId(@Path("id") id: Int): Response<Medico>
}