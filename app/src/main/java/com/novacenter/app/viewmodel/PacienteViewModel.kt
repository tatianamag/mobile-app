package com.novacenter.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.Paciente
import com.novacenter.app.data.model.PacienteUpdateRequest
import com.novacenter.app.data.network.PacienteService
import com.novacenter.app.data.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PacienteViewModel(private val pacienteService: PacienteService) : ViewModel() {

    private val _paciente = MutableStateFlow<Paciente?>(null)
    val paciente: StateFlow<Paciente?> = _paciente

    fun cargarPaciente(id: Int) {
        viewModelScope.launch {
            try {
                val response = pacienteService.obtenerDetallePaciente(id)
                if (response.isSuccessful) {
                    _paciente.value = response.body()
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

