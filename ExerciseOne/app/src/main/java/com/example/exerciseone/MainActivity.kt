package com.example.exerciseone

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkboxReading = findViewById<CheckBox>(R.id.checkboxReading)
        val checkboxTraveling = findViewById<CheckBox>(R.id.checkboxTraveling)
        val checkboxGaming = findViewById<CheckBox>(R.id.checkboxGaming)
        val checkboxCooking = findViewById<CheckBox>(R.id.checkboxCooking)
        val btnShowSelection = findViewById<Button>(R.id.btnShowSelection)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnShowSelection.setOnClickListener {
            val selectedHobbies = StringBuilder("Selected Hobbies: \n")
            if (checkboxReading.isChecked) selectedHobbies.append("- Reading\n")
            if (checkboxTraveling.isChecked) selectedHobbies.append("- Traveling\n")
            if (checkboxGaming.isChecked) selectedHobbies.append("- Gaming\n")
            if (checkboxCooking.isChecked) selectedHobbies.append("- Cooking\n")

            if (selectedHobbies.toString() == "Selected Hobbies: \n") {
                txtResult.text = "No hobbies selected"
            } else {
                txtResult.text = selectedHobbies.toString()
            }
        }
    }
}