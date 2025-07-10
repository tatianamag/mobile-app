package com.novacenter.app.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.novacenter.app.databinding.ActivityLoginBinding
import com.novacenter.app.ui.home.HomeActivity
import com.novacenter.app.viewmodel.UsuarioViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.usernameField.text.toString().trim()
            val password = binding.passwordField.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                binding.tvError.text = "Completa ambos campos"
                binding.tvError.visibility = android.view.View.VISIBLE
            } else {
                binding.tvError.visibility = android.view.View.GONE
                Log.d("Login", "Llamando a login con $username y $password")
                viewModel.login(username, password)
            }
        }

        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        // Observar el resultado del login
        lifecycleScope.launchWhenStarted {
            Log.d("Login", "Observando resultados del login")
            viewModel.usuarioLogueado.collect { response ->
                Log.d("Login", "Respuesta recibida: $response")
                if (response != null) {
                    val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    prefs.edit()
                        .putString("TOKEN", response.token)
                        .putInt("ID_PERSONA", response.idPersona)
                        .apply()

                    Toast.makeText(this@LoginActivity, "¡Login exitoso!", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                    finish()
                } else {
                    // Login fallido
                    binding.tvError.text = "Usuario o contraseña incorrectos"
                    binding.tvError.visibility = View.VISIBLE
                }
            }
        }
    }
}