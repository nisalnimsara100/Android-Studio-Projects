package com.example.internalserver

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: EmployeeDbHelper
    lateinit var etID: EditText
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var tvResult: TextView
    lateinit var btnInsert: Button
    lateinit var btnView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = EmployeeDbHelper(this)

        etID = findViewById(R.id.etEmpId)
        etName = findViewById(R.id.etEmpName)
        etEmail = findViewById(R.id.etEmpEmail)
        tvResult = findViewById(R.id.tvResult)
        btnInsert = findViewById(R.id.btnInsert)
        btnView = findViewById(R.id.btnView)

        btnInsert.setOnClickListener {
            val id = etID.text.toString().toIntOrNull()
            val name = etName.text.toString()
            val email = etEmail.text.toString()

            if (id != null && name.isNotEmpty() && email.isNotEmpty()) {
                val success = dbHelper.insertEmployee(id.toString(), name, email)
                if (success) {
                    Toast.makeText(this, "Employee inserted successfully.", Toast.LENGTH_SHORT).show()
                    etID.text.clear()
                    etName.text.clear()
                    etEmail.text.clear()
                } else {
                    Toast.makeText(this, "Failed to insert employee.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields correctly.", Toast.LENGTH_SHORT).show()
            }
        }
        btnView.setOnClickListener{
            val result = dbHelper.getAllEmployees()
            tvResult.text = result
        }
    }
}