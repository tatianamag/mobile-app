package com.novacenter.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.novacenter.app.databinding.ActivityLoginBinding
import com.novacenter.app.ui.usuario.viewmodel.UsuarioViewModel

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
                viewModel.login(username, password)
            }
        }

        // Observar el resultado del login
        lifecycleScope.launchWhenStarted {
            viewModel.usuarioLogueado.collect { response ->
                if (response != null) {
                    // Guardar el token en SharedPreferences
                    val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    prefs.edit().putString("TOKEN", response.token).apply()

                    Toast.makeText(this@LoginActivity, "¡Login exitoso!", Toast.LENGTH_SHORT).show()

                    // Ir a la Home (cambiá por tu propia pantalla)
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}