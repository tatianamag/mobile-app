package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.Medico
import com.novacenter.app.data.network.MedicoService
import com.novacenter.app.data.network.RetrofitInstance
import retrofit2.Response

class MedicoRepository(context: Context) {

    private val api = RetrofitInstance.getApiServiceWithToken(context).create(MedicoService::class.java)

    suspend fun obtenerMedicos(): Response<List<Medico>> = api.obtenerMedicos()
}