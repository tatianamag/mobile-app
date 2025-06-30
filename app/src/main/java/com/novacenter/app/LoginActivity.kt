package com.novacenter.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.novacenter.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botón de Ingresar
        binding.btnLogin.setOnClickListener {
            val email = binding.emailField.text.toString().trim()
            val password = binding.passwordField.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor completá todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí iría la llamada al ViewModel o Retrofit para iniciar sesión
                Toast.makeText(this, "Intentando iniciar sesión…", Toast.LENGTH_SHORT).show()
                // Ejemplo: startActivity(Intent(this, HomeActivity::class.java))
            }
        }

        // Link de recuperación
        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Funcionalidad de recuperación pendiente", Toast.LENGTH_SHORT).show()
        }
    }
}
