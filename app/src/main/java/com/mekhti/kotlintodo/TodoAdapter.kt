package com.mekhti.kotlintodo

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoAdapter(
    var todos:MutableList<Todo>
):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
            txt_todo.text = curTodo.title
            cb_todo.isChecked = curTodo.isChecked
            cb_todo.setOnClickListener {
                curTodo.isChecked = !curTodo.isChecked
                txtStrikeThrough(txt_todo,curTodo.isChecked)
            }
        }
    }

    fun addTodo(todo : Todo){
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun txtStrikeThrough(txtView:TextView,isChecked:Boolean){
        if (isChecked){
            txtView.paintFlags = txtView.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            txtView.paintFlags = txtView.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.todo_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return todos.size;
    }

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}