package com.example.assignment_1_finished

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.assignment_1_finished.databinding.ActivitySignInPageBinding
import com.example.assignment_1_finished.db.MyDbManager

class sign_in_page : AppCompatActivity() {
    lateinit var bindingClass : ActivitySignInPageBinding
    val myDbManager = MyDbManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignInPageBinding.inflate(layoutInflater)
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

    fun login(view: View){
        var username = bindingClass.userna.text.toString()
        var password = bindingClass.pass.text.toString()
        myDbManager.openDb()
        var flag = true
        var res = myDbManager.readDbData()
        myDbManager.closeDb()
        for (i in res){
                    if(i == username){
                        var intent = Intent(this, welcome_page::class.java)
                        flag = false
                        startActivity(intent)
                    }
                }
        if(flag == true) {
            val toast = Toast.makeText(applicationContext, "Incorrect login or password", Toast.LENGTH_LONG)
            toast.show()
        }

    }
    fun signupp(view: View){
        var intent = Intent(this, sign_up_page::class.java)
        startActivity(intent)
}
}