package com.example.connect

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnFetch = findViewById<Button>(R.id.btnFetch)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnFetch.setOnClickListener{

            val queue = Volley.newRequestQueue(this)
            val url = "https://jsonplaceholder.typicode.com/users/1"

            val stringRequest = StringRequest(
                Request.Method.GET,
                url,
                { response ->
                    val jsonObject = JSONObject(response)
                    val name = jsonObject.getString("name")
                    val email = jsonObject.getString("email")
                    tvResult.text = "Name: $name\nEmail: $email"
                },
                { error ->
                    tvResult.text = "Error: ${error.message}"
                })
            queue.add(stringRequest)
        }
    }
}