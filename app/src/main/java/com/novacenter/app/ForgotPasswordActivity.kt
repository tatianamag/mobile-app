package com.novacenter.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.novacenter.app.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    // 🚀 Función para generar contraseña aleatoria
    private fun generarPasswordAleatoria(longitud: Int = 8): String {
        val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..longitud)
            .map { caracteres.random() }
            .joinToString("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendReset.setOnClickListener {
            val email = binding.emailInput.text.toString().trim()

            if (email.isEmpty()) {
                binding.tvStatus.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                binding.tvStatus.text = "Por favor ingresá tu correo"
            } else {
                // Acá podrías invocar un ViewModel o una API real
                binding.tvStatus.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                binding.tvStatus.text = "Si el correo está registrado, recibirás una nueva contraseña"
            }
        }
    }
}
