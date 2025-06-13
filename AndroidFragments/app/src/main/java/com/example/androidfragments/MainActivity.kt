package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfragments.R
import com.example.androidfragments.fragment_a
import com.example.androidfragments.fragment_b

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnA = findViewById<Button>(R.id.btnLoadFragmentA)
        val btnB = findViewById<Button>(R.id.btnLoadFragmentB)

        btnA.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentController, fragment_a())
                .addToBackStack(null)
                .commit()

            btnB.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentController, fragment_b())
                    .addToBackStack(null)
                    .commit()


            }
        }
    }
}