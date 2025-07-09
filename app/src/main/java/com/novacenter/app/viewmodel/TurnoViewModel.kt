package com.novacenter.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.Turno
import com.novacenter.app.data.model.TurnoDTO
import com.novacenter.app.data.repository.TurnoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TurnoViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = TurnoRepository(application)

    private val _turnos = MutableStateFlow<List<Turno>>(emptyList())
    val turnos: StateFlow<List<Turno>> = _turnos

    fun cargarTurnos() {
        viewModelScope.launch {
            try {
                val response = repo.getTurnos()
                if (response.isSuccessful) {
                    _turnos.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun crearTurno(turnoDTO: TurnoDTO) {
        viewModelScope.launch {
            try {
                val response = repo.crearTurno(turnoDTO)
                if (response.isSuccessful) {
                    cargarTurnos()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}