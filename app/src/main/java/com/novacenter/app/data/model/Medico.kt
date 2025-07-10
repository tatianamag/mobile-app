package com.novacenter.app.data.model

import com.google.gson.annotations.SerializedName

data class Medico(
    @SerializedName("Id_Medico") val idMedico: Int,
    @SerializedName("Nombre") val nombre: String,
    @SerializedName("Especialidad") val especialidad: String
)
