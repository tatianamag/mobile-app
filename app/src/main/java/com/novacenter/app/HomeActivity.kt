Archivo: HomeActivity.kt:        package com.novacenter.app.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.novacenter.app.databinding.ActivityHomeBinding
import com.novacenter.app.ui.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collect

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(this)

        // Cargar usuarios desde la API
        viewModel.cargarUsuarios()

        // Observar cambios
        lifecycleScope.launchWhenStarted {
            viewModel.usuarios.collect { lista ->
                binding.recyclerUsuarios.adapter = UsuarioAdapter(lista)
            }
        }
    }
}