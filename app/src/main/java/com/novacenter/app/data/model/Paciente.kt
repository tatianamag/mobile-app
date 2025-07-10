package com.novacenter.app.data.model

data class Paciente(
    val id: Int,
    val nombre: String?,
    val sexo: String?,
    val fechaNacimiento: String?,
    val telefono: String?,
    val dni: String?,
    val cobertura: String?
)