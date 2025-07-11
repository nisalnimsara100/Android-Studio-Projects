package com.example.jsonobjects

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val jsonStr = """{
                "name" : "Alex",
                "course" : "Android",
                "age" : 38
        }"""

        val jsonObj = JSONObject(jsonStr)

        val name = jsonObj.getString("name")
        val course = jsonObj.getString("course")
        val age = jsonObj.getInt("age")

        val result: TextView = findViewById(R.id.textView)
        result.text = "Name: $name\nCourse: $course\nAge: $age"

    }
}