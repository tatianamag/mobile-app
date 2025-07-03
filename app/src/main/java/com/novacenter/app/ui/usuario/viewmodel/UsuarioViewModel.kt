package com.novacenter.app.ui.usuario.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.Usuario
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.repository.AuthRepository
import com.novacenter.app.data.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsuarioViewModel(application: Application) : AndroidViewModel(application) {

    // Usamos applicationContext para pasar a los repos
    private val authRepository = AuthRepository(application.applicationContext)
    private val usuarioRepository = UsuarioRepository(application.applicationContext)

    private val _usuarios = MutableStateFlow<List<Usuario>>(emptyList())
    val usuarios: StateFlow<List<Usuario>> = _usuarios

    private val _usuarioLogueado = MutableStateFlow<LoginResponse?>(null)
    val usuarioLogueado: StateFlow<LoginResponse?> = _usuarioLogueado

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(username, password)
                _usuarioLogueado.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                _usuarioLogueado.value = null
                _error.value = "No se pudo iniciar sesión. Verificá tus datos o intentá más tarde."
            }
        }
    }

    fun cargarUsuarios() {
        viewModelScope.launch {
            try {
                val usuariosDesdeApi = usuarioRepository.obtenerUsuarios()
                _usuarios.value = usuariosDesdeApi
            } catch (e: Exception) {
                e.printStackTrace()
                _usuarios.value = emptyList()
                _error.value = "Error al cargar la lista de usuarios."
            }
        }
    }
    fun limpiarError() {
        _error.value = null
    }
}

