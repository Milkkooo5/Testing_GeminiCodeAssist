package com.example.aitestingtools

import android.app.Activity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ai_testing_tools.R

class LoginActivity2 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvForgot = findViewById<TextView>(R.id.tvForgot)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            // Простая валидация: непустые поля, пароль >= 6, корректный email
            when {
                email.isEmpty() -> showToast("Введите email")
                password.isEmpty() -> showToast("Введите пароль")
                password.length < 6 -> showToast("Пароль должен быть не менее 6 символов")
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showToast("Введите корректный email")
                else -> {
                    // Здесь можно вызывать реальную аутентификацию (API, Firebase и т.д.)
                    showToast("Успешный вход 2 (демо)")
                    // finish() // или перейти на главный экран
                }
            }
        }

        tvForgot.setOnClickListener {
            showToast("Забыли пароль — действие 2 (демо)")
        }

        tvRegister.setOnClickListener {
            showToast("Регистрация — действие 2 (демо)")
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
