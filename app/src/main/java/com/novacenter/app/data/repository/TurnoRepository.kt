package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.Turno
import com.novacenter.app.data.network.RetrofitInstance

class TurnoRepository(context: Context) {
    private val api = RetrofitInstance.getRetrofit(context).create(com.novacenter.app.data.network.TurnoService::class.java)

    suspend fun getTurnos(): List<Turno> = api.obtenerTurnos()

    suspend fun crearTurno(turno: Turno): Turno = api.crearTurno(turno)
}
