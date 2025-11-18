package com.example.aitestingtools

import android.app.Activity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ai_testing_tools.R


class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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
                password.length < 6 -> showToast("Пароль должен быть не менее 6 символ��в")
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showToast("Введите корректный email")
                else -> {
                    // Здесь можно вызывать реальную аутентификацию (API, Firebase и т.д.)
                    showToast("Успешный вход (демо)")
                    // finish() // или перейти на главный экран
                }
            }
        }

        tvForgot.setOnClickListener {
            showToast("Забыли пароль — действие (демо)")
        }

        tvRegister.setOnClickListener {
            showToast("Регистра��ия — действие (демо)")
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
