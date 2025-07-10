package com.novacenter.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel(val authRepository: AuthRepository) : ViewModel() {

    private val _usuarioLogueado = MutableStateFlow<LoginResponse?>(null)
    val usuarioLogueado: StateFlow<LoginResponse?> = _usuarioLogueado

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                Log.d("Login", "Iniciando login desde ViewModel")
                val response = authRepository.login(username, password)
                if (response.isSuccessful) {
                    Log.d("Login", "Login exitoso: ${response.body()}")
                    _usuarioLogueado.value = response.body()
                } else {
                    Log.e("Login", "Login fallido: código ${response.code()}")
                    _usuarioLogueado.value = null  // login incorrecto
                }
            } catch (e: IOException) {
                Log.e("Login", "Error de red: ${e.message}")
                _usuarioLogueado.value = null  // error de red
            } catch (e: HttpException) {
                Log.e("Login", "Error HTTP: ${e.message}")
                _usuarioLogueado.value = null  // error HTTP
            } catch (e: Exception) {
                Log.e("Login", "Error inesperado: ${e.message}")
                _usuarioLogueado.value = null
            }
        }
    }
}