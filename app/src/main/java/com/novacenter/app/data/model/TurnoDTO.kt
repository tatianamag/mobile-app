package com.novacenter.app.data.model

import com.google.gson.annotations.SerializedName

data class TurnoDTO(
    @SerializedName("Id_Paciente") val idPaciente: Int,
    @SerializedName("Id_Motivo") val idMotivo: Int,
    @SerializedName("Id_Medico") val idMedico: Int,
    @SerializedName("Fecha_y_Hora") val fechaYHora: String,
    @SerializedName("Estado") val estado: String,
    @SerializedName("Detalle_Motivo") val detalleMotivo: String
)
