package com.mekhti.kotlintodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = TodoAdapter(mutableListOf())

        rv_todo.adapter = adapter
        rv_todo.layoutManager = LinearLayoutManager(this)

        btn_addTodo.setOnClickListener {
            val title = edt_todo.text.toString()
            if (!title.isEmpty()){
                val newTodo  = Todo(title)
                adapter.addTodo(newTodo)
                edt_todo.text.clear()
            }
        }
    }
}