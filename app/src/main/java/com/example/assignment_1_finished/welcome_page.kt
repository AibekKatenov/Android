package com.example.assignment_1_finished

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_1_finished.databinding.ActivityCreateBinding
import com.example.assignment_1_finished.databinding.ActivityWelcomePageBinding
import com.example.assignment_1_finished.db.MyBookStoreManager
import com.example.assignment_1_finished.db.MyDbManager

class welcome_page : AppCompatActivity() {
    lateinit var bindingClass : ActivityWelcomePageBinding
    val myBookStoreManager = MyBookStoreManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityWelcomePageBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val recyclerView = bindingClass.home2
        myBookStoreManager.openDb()
        var data = myBookStoreManager.readDbData()
        myBookStoreManager.closeDb()
        data class ListItem(val texts: ArrayList<String>)


        class ListAdapter(private val items: List<ListItem>) :
            RecyclerView.Adapter<ListAdapter.ViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_layout, parent, false)
                return ViewHolder(view)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val item = items[position]
                for (i in 0 until holder.textViews.size) {
                    if (i < item.texts.size) {
                        holder.textViews[i].text = item.texts[i]
                        holder.textViews[i].visibility = View.VISIBLE
                    } else {
                        holder.textViews[i].visibility = View.GONE
                    }
                }
            }

            override fun getItemCount(): Int = items.size

            inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val textViews: List<TextView> = listOf(
                    view.findViewById(R.id.list_item_text1),
                    view.findViewById(R.id.list_item_text2),
                    view.findViewById(R.id.list_item_text3),
                    view.findViewById(R.id.list_item_text4),
                    view.findViewById(R.id.list_item_text5),
                    view.findViewById(R.id.list_item_text6),
                    view.findViewById(R.id.list_item_text7)
                )
            }
        }

        val items = listOf(
            ListItem(data),
        )
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = ListAdapter(items)
        recyclerView.adapter = adapter
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun onClickNew(view: View){
        var a = Intent(this, CreateActivity::class.java)
        startActivity(a)
    }

    fun close(view: View){
        finish()
    }

    fun ed(view: View){
        var b = Intent(this, edit_page::class.java)
        startActivity(b)
    }

    fun delete(view: View){
        var book = bindingClass.namee.text.toString()
        myBookStoreManager.openDb()
        myBookStoreManager.del(book)
        myBookStoreManager.closeDb()
        bindingClass.namee.setText("")
    }
    fun edd(view: View){
        var b = Intent(this, Retrofit::class.java)
        startActivity(b)
    }
}