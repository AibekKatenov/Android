package com.example.assignment_1_finished.db

import android.provider.BaseColumns

object MyDbNameClass {
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "username"
    const val COLUMN_NAME_SUBTITLE = "password"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "My_data.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME(" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_SUBTITLE TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}