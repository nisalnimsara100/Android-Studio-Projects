package com.example.explicitintentdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * SecondActivity receives data from MainActivity and displays it.
 * Demonstrates retrieving data from an intent and passing control to ThirdActivity.
 */
class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Get reference to the TextView that will display the name
        val textView = findViewById<TextView>(R.id.textViewResult)
        
        // Retrieve the name passed from MainActivity using the key "user_name"
        val name = intent.getStringExtra("user_name")
        
        // Display the welcome message with the user's name
        textView.text = "Welcome, $name!"

        // Get reference to the confirmation button
        val button = findViewById<Button>(R.id.buttonThanks)

        // Set up click listener for the button to navigate to ThirdActivity
        button.setOnClickListener {
            // Create an explicit intent to launch ThirdActivity
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}
