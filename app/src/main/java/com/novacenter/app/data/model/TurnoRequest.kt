package com.novacenter.app.data.model

data class TurnoRequest(
    val pacienteId: Int,
    val medicoId: Int,
    val fecha: String, // formato ISO (ej: "2025-07-15T10:00:00")
    val detalleMotivo: String?,
    val motivoId: Int
)
