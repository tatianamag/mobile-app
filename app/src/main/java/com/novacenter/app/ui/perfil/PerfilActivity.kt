package com.novacenter.app.ui.perfil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.novacenter.app.data.network.RetrofitInstance
import com.novacenter.app.databinding.ActivityPerfilBinding
import com.novacenter.app.ui.login.LoginActivity
import com.novacenter.app.viewmodel.PacienteViewModel
import com.novacenter.app.viewmodel.PacienteViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding

    // ✅ Primero creamos la factory con el contexto
    private val factory by lazy {
        val pacienteService = RetrofitInstance.getPacienteService(this)
        PacienteViewModelFactory(pacienteService)
    }

    // ✅ Luego usamos la factory para instanciar el ViewModel
    private val viewModel: PacienteViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pacienteId = obtenerPacienteId()
        val token = getSharedPreferences("app_prefs", MODE_PRIVATE).getString("TOKEN", null)
        Log.d("Perfil", "Paciente ID: $pacienteId")
        Log.d("Perfil", "Token: $token")
        if (pacienteId != null) {
            viewModel.cargarPaciente(pacienteId)
        } else {
            Toast.makeText(this, "No se encontró el usuario", Toast.LENGTH_SHORT).show()
            finish()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.paciente.collect { paciente ->
                if (paciente != null) {
                    binding.tvNombreCompleto.text = paciente.nombre ?: "Sin nombre"
                    binding.tvCorreo.text = paciente.dni ?: "Sin DNI"
                    binding.tvDni.text = paciente.dni ?: "-"
                    binding.tvDireccion.text = "No disponible" // Si no tenés dirección, podés dejarlo así
                    binding.tvTelefono.text = paciente.telefono ?: "-"
                    binding.tvObraSocial.text = paciente.cobertura ?: "-"
                    binding.tvUsuario.text = paciente.nombre?.lowercase()?.replace(" ", ".") ?: "-"
                    binding.tvContrasena.text = "●●●●●●●●"
                }
            }
        }

        binding.btnModificarDatos.setOnClickListener {
            Toast.makeText(this, "Funcionalidad en desarrollo", Toast.LENGTH_SHORT).show()
        }

        binding.btnCerrarSesion.setOnClickListener {
            cerrarSesion()
        }
    }

    private fun obtenerPacienteId(): Int? {
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val id = prefs.getInt("ID_PERSONA", -1)
        return if (id != -1) id else null
    }

    private fun cerrarSesion() {
        getSharedPreferences("usuario", MODE_PRIVATE).edit().clear().apply()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
