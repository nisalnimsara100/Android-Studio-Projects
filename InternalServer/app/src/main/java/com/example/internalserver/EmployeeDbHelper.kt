package com.example.internalserver

import android.content.ContentValues
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class EmployeeDbHelper(context: Context):
        SQLiteOpenHelper(context, "Employee Name", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE Employee (
                id INTEGER PRIMARY KEY,
                name TEXT,
                email TEXT
            )
        """.trimIndent()

        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Employee")
        onCreate(db)
    }

    fun insertEmployee(name: String, email: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("email", email)
        }

        val result = db.insert("Employee", null, values)
        return result != -1L

    }

    fun getAllEmployees():String{
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Employee", null)
        val builder = StringBuilder()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val email = cursor.getString(2)
                builder.append("ID: $id, Name: $name, Email: $email\n")
            } while (cursor.moveToNext())
        }
        cursor.close()
        return builder.toString()
    }

}