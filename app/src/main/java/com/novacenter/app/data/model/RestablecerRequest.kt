package com.novacenter.app.data.model

import com.google.gson.annotations.SerializedName

data class RestablecerRequest(
    @SerializedName("Token") val token: String,
    @SerializedName("NuevaContrasena") val nuevaContrasena: String
)
