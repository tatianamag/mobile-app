package com.novacenter.app.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://localhost:5000" // reemplazalo con tu endpoint real

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val turnoService: TurnoService by lazy {
        retrofit.create(TurnoService::class.java)
    }

    val authService: AuthService by lazy {
        retrofit.create(AuthService::class.java)
    }

    val usuarioService: UsuarioService by lazy {
        retrofit.create(UsuarioService::class.java)
    }

}
