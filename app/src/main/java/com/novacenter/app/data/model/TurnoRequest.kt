package com.novacenter.app.data.model

data class TurnoRequest(
    val PacienteId: Int,
    val MedicoId: Int,
    val MotivoId: Int,
    val Fecha: String,
    val DetalleMotivo: String?,
)


