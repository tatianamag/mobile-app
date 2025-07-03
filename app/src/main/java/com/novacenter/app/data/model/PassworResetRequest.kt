package com.novacenter.app.data.model

data class PasswordResetRequest(
    val token: String,
    val nueva: String
)
