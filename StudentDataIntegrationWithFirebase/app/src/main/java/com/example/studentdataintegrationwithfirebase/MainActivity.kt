package com.example.studentdataintegrationwithfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSave: Button
    private lateinit var btnView: Button
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etEmail = findViewById(R.id.etEmail)
        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnView)

        database = FirebaseDatabase.getInstance()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageStr = etAge.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (name.isEmpty() || ageStr.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = ageStr.toIntOrNull()
            if (age == null) {
                Toast.makeText(this, "Please enter a valid age", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val student = Student(name, age, email)
            val databaseReference = database.getReference("students")
            val studentId = databaseReference.push().key
            if (studentId != null) {
                databaseReference.child(studentId).setValue(student)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Student data saved successfully", Toast.LENGTH_SHORT).show()
                        clearFields()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to save data: ${it.message}", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        btnView.setOnClickListener {
            startActivity(Intent(this, ViewStudentsActivity::class.java))
        }
    }

    private fun clearFields() {
        etName.text.clear()
        etAge.text.clear()
        etEmail.text.clear()
    }
}