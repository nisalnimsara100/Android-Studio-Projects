package com.example.simplegalleryapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var imageView : ImageView
    lateinit var buttonImage1: Button
    lateinit var buttonImage2: Button
    lateinit var buttonImage3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        buttonImage1 = findViewById(R.id.buttonImage1)
        buttonImage2 = findViewById(R.id.buttonImage2)
        buttonImage3 = findViewById(R.id.buttonImage3)

        buttonImage1.setOnClickListener {
            imageView.setImageResource(R.drawable.sigiriya)
        }

        buttonImage2.setOnClickListener {
            imageView.setImageResource(R.drawable.galle)
        }

        buttonImage3.setOnClickListener {
            imageView.setImageResource(R.drawable.kandy)
        }
    }
}