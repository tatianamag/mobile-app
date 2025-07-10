package com.novacenter.app.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.novacenter.app.databinding.ActivitySplashBinding
import com.novacenter.app.ui.login.LoginActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val splashDuration = 2000L // duración en ms

    private val splashScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splashScope.launch {
            delay(splashDuration)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        splashScope.cancel() // cancelar corutina si la activity se destruye antes
        super.onDestroy()
    }
}
