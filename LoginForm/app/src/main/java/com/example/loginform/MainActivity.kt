package com.example.loginform

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.editUsername)
        val password = findViewById<EditText>(R.id.editPassword)
        val loginBtn = findViewById<Button>(R.id.btnLogin)
        val resetBtn = findViewById<Button>(R.id.btnReset)

        val existUsername = "Admin"
        val existPassword = "admin"

        loginBtn.setOnClickListener{
            val user = username.text.toString()
            val pass = password.text.toString()
            if (user == existUsername && pass == existPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }

        resetBtn.setOnClickListener {
            username.text.clear()
            password.text.clear()
        }
    }
}