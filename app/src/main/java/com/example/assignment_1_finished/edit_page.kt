package com.example.assignment_1_finished

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.assignment_1_finished.databinding.ActivityCreateBinding
import com.example.assignment_1_finished.databinding.ActivityEditPageBinding
import com.example.assignment_1_finished.db.MyBookStoreManager

class edit_page : AppCompatActivity() {
    lateinit var bindingClass : ActivityEditPageBinding
    val myBookStoreManager = MyBookStoreManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityEditPageBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun d(view: View){
        var old = bindingClass.text1.text.toString()
        var new = bindingClass.text3.text.toString()
        myBookStoreManager.openDb()
        myBookStoreManager.upgrade(old,new)
        myBookStoreManager.closeDb()
        bindingClass.text1.setText("")
        bindingClass.text3.setText("")
        finish()
    }
}