package com.example.listviewwitharrayadapter

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val countries = arrayOf(
        "Sri Lanka", "India", "USA", "Canada", "Australia", "Germany",
        "France", "Italy", "Spain", "Japan", "China"
    )

}