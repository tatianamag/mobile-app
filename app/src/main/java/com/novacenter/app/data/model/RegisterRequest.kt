package com.novacenter.app.data.model

data class RegisterRequest(
    val nombre: String,
    val email: String,
    val password: String
)