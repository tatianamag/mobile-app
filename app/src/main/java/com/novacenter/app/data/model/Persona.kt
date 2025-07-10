package com.novacenter.app.data.model

data class Persona(
    val id: Int,
    val nombre: String?,
    val sexo: String?,
    val fechaNacimiento: String?,
    val telefono: String?,
    val dni: String?,
    val cobertura: String?
)