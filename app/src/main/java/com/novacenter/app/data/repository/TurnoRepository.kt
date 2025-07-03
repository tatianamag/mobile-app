package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.Turno
import com.novacenter.app.data.model.TurnoDTO
import com.novacenter.app.data.network.RetrofitInstance
import com.novacenter.app.data.network.TurnoService
import retrofit2.Response

class TurnoRepository(context: Context) {

    private val api = RetrofitInstance.getRetrofit(context).create(TurnoService::class.java)

    suspend fun getTurnos(): Response<List<Turno>> {
        return api.obtenerTurnos()
    }

    suspend fun crearTurno(turno: TurnoDTO): Response<Turno> {
        return api.crearTurno(turno)
    }

    suspend fun getTurnoPorId(id: Int): Response<Turno> {
        return api.obtenerTurnoPorId(id)
    }

    suspend fun actualizarTurno(id: Int, turno: TurnoDTO): Response<Unit> {
        return api.actualizarTurno(id, turno)
    }

    suspend fun eliminarTurno(id: Int): Response<Unit> {
        return api.eliminarTurno(id)
    }
}