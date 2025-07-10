package com.novacenter.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.Persona
import com.novacenter.app.data.model.PacienteUpdateRequest
import com.novacenter.app.data.network.PacienteService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PacienteViewModel(private val pacienteService: PacienteService) : ViewModel() {

    private val _paciente = MutableStateFlow<Persona?>(null)
    val paciente: StateFlow<Persona?> = _paciente

    fun cargarPaciente(id: Int) {
        viewModelScope.launch {
            try {
                val response = pacienteService.obtenerDetallePaciente(id)
                Log.d("PacienteVM", "Código HTTP: ${response.code()}")
                if (response.isSuccessful) {
                    _paciente.value = response.body()
                } else {
                    Log.e("PacienteVM", "Error al obtener datos: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("Paciente", "Error: ${e.message}")
            }
        }
    }

    fun actualizarPaciente(id: Int, datos: PacienteUpdateRequest) {
        viewModelScope.launch {
            try {
                pacienteService.editarPaciente(id, datos)
            } catch (e: Exception) {
                Log.e("Paciente", "Error: ${e.message}")
            }
        }
    }
}

