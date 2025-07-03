package com.novacenter.app.data.model

data class Usuario(
    val id_persona: Int,
    val nombre: String,
    val email: String,
    val estado: String,
    val fecha_ultimo_login: String?,
    val intentos_fallidos: Int,
    val bloqueado: Boolean
)