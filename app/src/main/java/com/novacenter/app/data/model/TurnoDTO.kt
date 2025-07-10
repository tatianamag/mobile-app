package com.novacenter.app.data.model

import com.google.gson.annotations.SerializedName

data class TurnoDTO(
    val id: Int,
    val pacienteId: Int,
    val medicoId: Int,
    val fecha: String, // o LocalDateTime si usás adaptador
    val paciente: Persona?,
    val medico: Medico?
)

