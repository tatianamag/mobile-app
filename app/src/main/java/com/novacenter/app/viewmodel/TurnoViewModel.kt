package com.novacenter.app.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.TurnoRequest
import com.novacenter.app.data.model.TurnoDTO
import com.novacenter.app.data.repository.TurnoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TurnoViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = TurnoRepository(application)

    private val _turnos = MutableStateFlow<List<TurnoDTO>>(emptyList())
    val turnos: StateFlow<List<TurnoDTO>> = _turnos

    fun cargarTurnos() {
        viewModelScope.launch {
            try {
                val response = repo.obtenerTurnos()
                if (response.isSuccessful) {
                    val lista = response.body() ?: emptyList()
                    _turnos.value = lista
                } else {
                    Log.e("TurnoVM", "Error HTTP: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun crearTurno(turnoDTO: TurnoDTO) {
        viewModelScope.launch {
            try {
                val response = repo.agregarTurno(turnoDTO)
                if (response.isSuccessful) {
                    cargarTurnos()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}