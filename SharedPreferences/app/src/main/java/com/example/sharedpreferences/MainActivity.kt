package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tvGreeting: TextView
    private lateinit var etUsername: EditText
    private lateinit var btnSave: Button

    private val PREFS_NAME = "MyPrefs"
    private val KEY_NAME = "username"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvGreeting = findViewById(R.id.tvGreeting)
        etUsername = findViewById(R.id.etUsername)
        btnSave = findViewById(R.id.btnSave)

        val sharePref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedName = sharePref.getString(KEY_NAME, null)

        if (savedName != null) {
            tvGreeting.text = "Welcome back, $savedName!"
        }

        btnSave.setOnClickListener {
            val name = etUsername.text.toString().trim()

            if (name.isNotEmpty()) {
                val editor = sharePref.edit()
                editor.putString(KEY_NAME, name)
                editor.apply()

                tvGreeting.text = "Welcome, $name!"
                etUsername.text.clear()
            }
        }
    }
}