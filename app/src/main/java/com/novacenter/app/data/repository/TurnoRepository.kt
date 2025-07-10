package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.model.TurnoDTO
import com.novacenter.app.data.network.ApiService
import com.novacenter.app.data.network.RetrofitInstance
import retrofit2.Response

class TurnoRepository(private val context: Context) {

    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return RetrofitInstance.authService.login(request)
    }

    suspend fun obtenerTurnos(): Response<List<TurnoDTO>> {
        val api = RetrofitInstance.getApiServiceWithToken(context).create(ApiService::class.java)
        return api.obtenerTurnos()
    }

    suspend fun agregarTurno(turno: TurnoDTO): Response<TurnoDTO> {
        val api = RetrofitInstance.getApiServiceWithToken(context).create(ApiService::class.java)
        return api.agregarTurno(turno)
    }

    suspend fun obtenerDetalle(id: Int): Response<TurnoDTO> {
        val api = RetrofitInstance.getApiServiceWithToken(context).create(ApiService::class.java)
        return api.obtenerDetalle(id)
    }
}
