package com.novacenter.app.data.model

data class LoginResponse(
    val token: String,
    val rol: String,
    val nombre: String
)
