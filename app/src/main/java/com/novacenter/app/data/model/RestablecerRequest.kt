package com.novacenter.app.data.model

data class RestablecerRequest(
    val token: String,
    val nuevaContrasena: String
)