package com.example.explicitintentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * MainActivity is the entry point of the application.
 * Demonstrates sending data to another activity using Explicit Intent.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the UI elements
        val editText = findViewById<EditText>(R.id.editTextName)
        val button = findViewById<Button>(R.id.buttonSend)

        // Set up click listener for the send button
        button.setOnClickListener {
            // Retrieve the text entered by the user
            val name = editText.text.toString()
            
            // Create an explicit intent to launch SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            
            // Add the user's name as extra data to the intent
            // The key "user_name" will be used to retrieve this data in SecondActivity
            intent.putExtra("user_name", name)
            
            // Start the second activity
            startActivity(intent)
        }
    }
}
