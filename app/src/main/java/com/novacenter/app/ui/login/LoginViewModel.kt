import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novacenter.app.data.model.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.novacenter.app.data.repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel(val authRepository: AuthRepository) : ViewModel() {

    private val _usuarioLogueado = MutableStateFlow<LoginResponse?>(null)
    val usuarioLogueado: StateFlow<LoginResponse?> = _usuarioLogueado

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(username, password)
                _usuarioLogueado.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                _usuarioLogueado.value = null
            }
        }
    }
}
