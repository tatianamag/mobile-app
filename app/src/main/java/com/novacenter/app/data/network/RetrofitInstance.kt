package com.novacenter.app.data.network

import android.content.Context
import com.novacenter.app.data.network.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://localhost:5000" // reemplazalo con tu endpoint real

    // Cliente sin token (por ejemplo, para login)
    private val retrofitNoAuth: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Usalo así: RetrofitInstance.createRetrofit(context).create(UsuarioService::class.java)
    fun createRetrofit(context: Context): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Servicios públicos (sin autenticación)
    val authService: AuthService by lazy {
        retrofitNoAuth.create(AuthService::class.java)
    }
}
