package com.example.assignment_1_finished

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.assignment_1_finished.databinding.ActivityCreateBinding
import com.example.assignment_1_finished.databinding.ActivitySignInPageBinding
import com.example.assignment_1_finished.db.MyBookStoreManager

class CreateActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityCreateBinding
    val myBookStoreManager = MyBookStoreManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityCreateBinding.inflate(layoutInflater)
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

    fun send(view: View){
        myBookStoreManager.openDb()
        myBookStoreManager.insertToDb(bindingClass.title.text.toString(),bindingClass.subtitle.text.toString())
        bindingClass.title.setText("")
        bindingClass.subtitle.setText("")
        finish()
    }

    override fun onStop() {
        super.onStop()
        myBookStoreManager.closeDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myBookStoreManager.closeDb()
    }
}