package com.novacenter.app.viewmodel

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
import retrofit2.HttpException
import java.io.IOException

class UsuarioViewModel(application: Application) : AndroidViewModel(application) {

    private val authRepository = AuthRepository()
    private val repository = UsuarioRepository(application)

    private val _usuarios = MutableStateFlow<List<Usuario>>(emptyList())
    val usuarios: StateFlow<List<Usuario>> = _usuarios

    private val _usuarioLogueado = MutableStateFlow<LoginResponse?>(null)
    val usuarioLogueado: StateFlow<LoginResponse?> = _usuarioLogueado

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(username, password)
                _usuarioLogueado.value = if (response.isSuccessful) response.body() else null
            } catch (e: IOException) {
                e.printStackTrace()
                _usuarioLogueado.value = null
            } catch (e: HttpException) {
                e.printStackTrace()
                _usuarioLogueado.value = null
            }
        }
    }

    fun cargarUsuarios() {
        viewModelScope.launch {
            try {
                val response = repository.obtenerUsuarios()
                if (response.isSuccessful) {
                    _usuarios.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}