package com.example.app.model

data class Turno(
    val id: Int,
    val id_paciente: Int,
    val id_motivo: Int,
    val id_medico: Int,
    val fecha_y_hora: String,
    val estado: String,
    val detalle_motivo: String
)
