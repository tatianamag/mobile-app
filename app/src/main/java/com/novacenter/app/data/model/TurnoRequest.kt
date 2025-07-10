package com.novacenter.app.data.model

data class TurnoRequest(
    val Id_Paciente: Int,
    val Id_Medico: Int,
    val Id_Motivo: Int,
    val Fecha_y_Hora: String, // "2025-07-15T10:00:00"
    val Detalle_Motivo: String?,
    val Estado: String = "pendiente" // opcional si lo maneja el backend
)

