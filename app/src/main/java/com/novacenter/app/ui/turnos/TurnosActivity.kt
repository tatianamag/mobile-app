package com.novacenter.app.ui.turnos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.novacenter.app.data.network.ApiService
import com.novacenter.app.databinding.ActivityTurnosBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TurnosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTurnosBinding

    private val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://tuservidor/api/") // URL real de tu backend
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurnosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerTurnos.layoutManager = LinearLayoutManager(this)

        cargarTurnosDesdeApi()
    }

    private fun cargarTurnosDesdeApi() {
        lifecycleScope.launch {
            try {
                val response = api.obtenerTurnos()
                if (response.isSuccessful) {
                    val turnosApi = response.body() ?: emptyList()
                    binding.recyclerTurnos.adapter = TurnoAdapter(turnosApi)
                } else {
                    // Mostrar error si la respuesta no fue exitosa
                    println("Error al obtener turnos: ${response.code()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
