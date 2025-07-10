package com.novacenter.app.data.network

import com.novacenter.app.data.model.RecuperarRequest
import com.novacenter.app.data.model.RestablecerRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface PasswordRecoveryService {
    @POST("auth/solicitar-recuperacion")
    suspend fun solicitarRecuperacion(@Body req: RecuperarRequest): Response<String>

    @POST("auth/restablecer")
    suspend fun restablecer(@Body req: RestablecerRequest): Response<String>
}
