package com.novacenter.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.novacenter.app.databinding.ActivityHomeBinding
import com.novacenter.app.ui.usuario.adapter.UsuarioAdapter
import com.novacenter.app.ui.usuario.viewmodel.UsuarioViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(this)

        // BOTONES (SIN CONFIGURAR AUN)
        //binding.botonSolicitarTurno.setOnClickListener {
         //   startActivity(Intent(this, TurnoActivity::class.java))
        //}

        //binding.botonCartilla.setOnClickListener {
         //   startActivity(Intent(this, CartillaActivity::class.java))
        //}

        // Cargar usuarios desde la API
        viewModel.cargarUsuarios()

        // Observar cambios
        lifecycleScope.launchWhenStarted {
            viewModel.usuarios.collect { lista ->
                binding.recyclerUsuarios.adapter = UsuarioAdapter(lista)
            }
        }
        // 👉 Acá va el nuevo bloque para el botón "Contacto"
        binding.contactoCard.setOnClickListener {
            val intent = Intent(this, com.novacenter.app.ui.contacto.ContactoActivity::class.java)
            startActivity(intent)
        }
        // 👉 Listener del BottomNavigationView
        binding.navBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Ya estás en Home, podés hacer scrollTop si querés
                    true
                }

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