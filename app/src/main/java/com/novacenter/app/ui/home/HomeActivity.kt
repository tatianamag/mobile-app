package com.novacenter.app.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.novacenter.app.R
import com.novacenter.app.databinding.ActivityHomeBinding
import com.novacenter.app.ui.salud.MiSaludActivity
import com.novacenter.app.ui.turnos.MisTurnosActivity
import com.novacenter.app.ui.perfil.PerfilActivity
import com.novacenter.app.ui.usuario.UsuarioAdapter
import com.novacenter.app.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(this)
        viewModel.cargarUsuarios()

        lifecycleScope.launch {
            viewModel.usuarios.collectLatest { lista ->
                binding.recyclerUsuarios.adapter = UsuarioAdapter(lista)
            }
        }

        binding.navBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_salud -> {
                    startActivity(Intent(this, MiSaludActivity::class.java))
                    true
                }
                R.id.nav_turnos -> {
                    startActivity(Intent(this, MisTurnosActivity::class.java))
                    true
                }
                R.id.nav_perfil -> {
                    startActivity(Intent(this, PerfilActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}