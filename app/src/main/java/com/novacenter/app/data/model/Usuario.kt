package com.novacenter.app.data.model

data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String,
    val username: String,
    val password: String? = null,  // Solo se usa para login o alta
    val token: String? = null      // Solo se usa si viene incluido en la respuesta de login
)
