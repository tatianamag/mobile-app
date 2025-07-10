package com.novacenter.app.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("iD_persona") val idPersona: Int,
    val dni: String,
    val nombreCompleto: String,
    val rol: String,
    val token: String
)
