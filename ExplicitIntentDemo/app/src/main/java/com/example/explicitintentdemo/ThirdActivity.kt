package com.example.explicitintentdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * ThirdActivity represents the final destination in the app flow.
 * Simply displays a thank you message to complete the demo.
 */
class ThirdActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        // Get reference to the thank you message TextView
        val textView = findViewById<TextView>(R.id.textViewThankYou)
        
        // Set the thank you message
        textView.text = "Thank You!"
        
        // Note: In a real app, we might add a button here to navigate back to MainActivity
        // or implement other functionality
    }
}
