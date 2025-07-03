package com.novacenter.app.data.model

data class QRToken(
    val id: Int,
    val id_turno: Int,
    val token: String,
    val fechaGeneracion: String,
    val usado: Boolean
)
