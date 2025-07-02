package com.novacenter.app.model

data class Turno(
    val fecha: String,          // ej: "Lunes 5/08"
    val hora: String,           // ej: "10:30hs"
    val medico: String,         // ej: "Dr. Rivas"
    val especialidad: String    // ej: "Traumatología"
)
