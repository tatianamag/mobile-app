package com.novacenter.app.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("dni")
    val dni: String,

    @SerializedName("contraseña")
    val contraseña: String
)
