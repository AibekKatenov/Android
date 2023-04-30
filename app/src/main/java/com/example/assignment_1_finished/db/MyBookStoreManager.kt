package com.example.assignment_1_finished.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
class MyBookStoreManager(val context: Context) {
    val myDbHelper = MyBookStoreHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(bookname: String, booklinkimage: String ){
        val values = ContentValues().apply {
            put(MyBookStoreClass.COLUMN_NAME_TITLE, bookname)
            put(MyBookStoreClass.COLUMN_NAME_SUBTITLE, booklinkimage)
        }
        db?.insert(MyBookStoreClass.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData() : ArrayList<String>{
        val dataList = ArrayList<String>()
        val cursor = db?.query(MyBookStoreClass.TABLE_NAME, null, null, null, null,
            null, null)
        while(cursor?.moveToNext()!!){
            val dataText = cursor.getString(cursor.getColumnIndex(MyBookStoreClass.COLUMN_NAME_TITLE))
            dataList.add(dataText.toString())
        }
        cursor.close()
        return dataList
    }

    fun del(book: String){
        MyBookStoreClass.deleteBookByName(book, db)
    }

    fun upgrade(old: String, new:String){
        MyBookStoreClass.updateBookName(old,new,db)
    }

    fun closeDb(){
        myDbHelper.close()
    }
}