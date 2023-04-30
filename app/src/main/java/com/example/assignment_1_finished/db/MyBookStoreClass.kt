package com.example.assignment_1_finished.db

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

object MyBookStoreClass {
        const val TABLE_NAME = "my_store"
        const val COLUMN_NAME_TITLE = "bookname"
        const val COLUMN_NAME_SUBTITLE = "bookimagelink"

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "My_bookstore1.db"

        const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME(" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_SUBTITLE TEXT)"
        const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        fun deleteBookByName(bookName: String, db: SQLiteDatabase?) {
                db?.let {
                        val selection = "$COLUMN_NAME_TITLE LIKE ?"
                        val selectionArgs = arrayOf(bookName)

                        it.delete(TABLE_NAME, selection, selectionArgs)
                }
        }
        fun updateBookName(oldName: String, newName: String, db: SQLiteDatabase?) {
                db?.let {
                        val values = ContentValues().apply {
                                put(COLUMN_NAME_TITLE, newName)
                        }

                        val selection = "$COLUMN_NAME_TITLE LIKE ?"
                        val selectionArgs = arrayOf(oldName)

                        it.update(TABLE_NAME, values, selection, selectionArgs)
                }
        }

}