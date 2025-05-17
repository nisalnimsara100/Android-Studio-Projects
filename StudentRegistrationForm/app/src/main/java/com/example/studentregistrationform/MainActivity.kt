package com.example.studentregistrationform

import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.editName)
        val email = findViewById<EditText>(R.id.editEmail)
        val phone = findViewById<EditText>(R.id.editPhone)
        val dob = findViewById<EditText>(R.id.editDob)
        val genderGroup =  findViewById<RadioGroup>(R.id.genderGroup)

        val subminBtn = findViewById<Button>(R.id.btnSubmit)

        subminBtn.setOnClickListener{
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId)?.text ?: "Not Selected"

            val message = """
                Name: ${name.text}
                Email: ${email.text}
                Phone: ${phone.text}
                DOB: ${dob.text}
                Gender: $gender
            """.trimIndent()

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}