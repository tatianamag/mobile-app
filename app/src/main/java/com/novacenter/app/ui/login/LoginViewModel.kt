package com.novacenter.app.ui.login

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
                val response = authRepository.login(username, password)
                if (response.isSuccessful) {
                    _usuarioLogueado.value = response.body()
                } else {
                    _usuarioLogueado.value = null  // login incorrecto
                }
            } catch (e: IOException) {
                e.printStackTrace()
                _usuarioLogueado.value = null  // error de red
            } catch (e: HttpException) {
                e.printStackTrace()
                _usuarioLogueado.value = null  // error HTTP
            } catch (e: Exception) {
                e.printStackTrace()
                _usuarioLogueado.value = null
            }
        }
    }
}