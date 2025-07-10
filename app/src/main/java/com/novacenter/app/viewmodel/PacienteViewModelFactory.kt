package com.novacenter.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.novacenter.app.data.network.PacienteService

class PacienteViewModelFactory(
    private val pacienteService: PacienteService
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PacienteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PacienteViewModel(pacienteService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
