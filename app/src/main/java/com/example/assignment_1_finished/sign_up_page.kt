package com.example.assignment_1_finished

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.assignment_1_finished.databinding.ActivityMainBinding
import com.example.assignment_1_finished.databinding.ActivitySignInPageBinding
import com.example.assignment_1_finished.databinding.ActivitySignUpPageBinding
import com.example.assignment_1_finished.db.MyDbManager

class sign_up_page : AppCompatActivity() {
    lateinit var bindingClass : ActivitySignUpPageBinding
    val myDbManager = MyDbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignUpPageBinding.inflate(layoutInflater)
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

    fun close(view: View){
        myDbManager.openDb()
        myDbManager.insertToDb(bindingClass.userr.text.toString(),bindingClass.passw.text.toString())
        finish()
    }

    override fun onStop() {
        super.onStop()
        myDbManager.closeDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}