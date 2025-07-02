package com.novacenter.app.ui.usuario.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.model.Usuario
import com.novacenter.app.data.repository.AuthRepository
import com.novacenter.app.data.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsuarioViewModel(application: Application) : AndroidViewModel(application) {

    private val authRepo = AuthRepository()
    private val usuarioRepo = UsuarioRepository(application)

    private val _usuarioLogueado = MutableStateFlow<LoginResponse?>(null)
    val usuarioLogueado: StateFlow<LoginResponse?> = _usuarioLogueado

    private val _usuarios = MutableStateFlow<List<Usuario>>(emptyList())
    val usuarios: StateFlow<List<Usuario>> = _usuarios

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepo.login(username, password)
                _usuarioLogueado.value = response
            } catch (e: Exception) {
                _usuarioLogueado.value = null
            }
        }
    }

    fun cargarUsuarios() {
        viewModelScope.launch {
            try {
                val lista = usuarioRepo.obtenerUsuarios()
                _usuarios.value = lista
            } catch (_: Exception) {}
        }
    }
}
