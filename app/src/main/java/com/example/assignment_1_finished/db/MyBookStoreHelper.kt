package com.example.assignment_1_finished.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyBookStoreHelper (context: Context) : SQLiteOpenHelper(context, MyBookStoreClass.DATABASE_NAME,
    null, MyBookStoreClass.DATABASE_VERSION ) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyBookStoreClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(MyBookStoreClass.SQL_DELETE_TABLE)
    }
}