package com.novacenter.app.data.model

data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String,
    val username: String,
    val password: String? = null,
    val token: String? = null
)
