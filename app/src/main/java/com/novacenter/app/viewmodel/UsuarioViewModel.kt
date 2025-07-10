package com.novacenter.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsuarioViewModel : ViewModel() {

    private val _usuarioLogueado = MutableStateFlow<LoginResponse?>(null)
    val usuarioLogueado: StateFlow<LoginResponse?> = _usuarioLogueado

    fun login(dni: String, contraseña: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.authService.login(LoginRequest(dni, contraseña))
                if (response.isSuccessful) {
                    _usuarioLogueado.value = response.body()
                } else {
                    Log.e("Login", "Error en login: ${response.code()}")
                    _usuarioLogueado.value = null
                }
            } catch (e: Exception) {
                Log.e("Login", "Excepción: ${e.message}")
                _usuarioLogueado.value = null
            }
        }
    }
}
