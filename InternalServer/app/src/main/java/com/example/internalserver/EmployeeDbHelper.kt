package com.example.internalserver

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

}