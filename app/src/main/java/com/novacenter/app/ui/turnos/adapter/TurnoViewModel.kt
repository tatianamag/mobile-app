package com.novacenter.app.ui.turno.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.Turno
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
                val lista = repo.getTurnos()
                _turnos.value = lista
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun crearTurno(turno: Turno) {
        viewModelScope.launch {
            try {
                repo.crearTurno(turno)
                cargarTurnos() // refrescar la lista después de crear
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
