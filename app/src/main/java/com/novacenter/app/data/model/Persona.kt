package com.novacenter.app.data.model

    data class Persona(
        val id_persona: Int,
        val nombre_completo: String,
        val sexo: String,
        val telefono: String,
        val dni: String,
        val cobertura: String,
        val tipo: String,
        val email: String
    )
