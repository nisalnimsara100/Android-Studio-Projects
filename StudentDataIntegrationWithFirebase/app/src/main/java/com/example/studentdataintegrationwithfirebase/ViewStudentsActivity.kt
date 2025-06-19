package com.example.studentdataintegrationwithfirebase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ViewStudentsActivity : AppCompatActivity() {

    private lateinit var rvStudents: RecyclerView
    private lateinit var database: FirebaseDatabase
    private lateinit var studentList: MutableList<Student>
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_students)
        Log.d("ViewStudentsActivity", "Layout set to R.layout.activity_view_students")

        rvStudents = findViewById(R.id.rvStudents) ?: run {
            Log.e("ViewStudentsActivity", "rvStudents not found! Check R.id.rvStudents in activity_view_students.xml")
            return
        }
        rvStudents.layoutManager = LinearLayoutManager(this)
        Log.d("ViewStudentsActivity", "rvStudents initialized: ${rvStudents.id}")

        database = FirebaseDatabase.getInstance()
        studentList = mutableListOf()
        adapter = StudentAdapter(studentList)
        rvStudents.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fetchStudents()
    }

    private fun fetchStudents() {
        val databaseReference = database.getReference("students")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                studentList.clear()
                for (dataSnapshot in snapshot.children) {
                    val student = dataSnapshot.getValue(Student::class.java)
                    student?.let { studentList.add(it) }
                }
                adapter.notifyDataSetChanged()
                if (studentList.isEmpty()) {
                    Toast.makeText(this@ViewStudentsActivity, "No students found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ViewStudentsActivity, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}