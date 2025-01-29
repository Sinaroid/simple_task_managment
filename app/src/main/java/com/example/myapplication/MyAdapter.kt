package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.graphics.Paint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.text_item)
        val editText: View = itemView.findViewById(R.id.edit_button)
        val checkBox: View = itemView.findViewById(R.id.check_item)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = list[position]
        holder.checkBox.setOnClickListener {
            holder.itemText.paintFlags = holder.itemText.paintFlags or STRIKE_THRU_TEXT_FLAG
            holder.checkBox.visibility = View.INVISIBLE
            holder.editText.visibility = View.INVISIBLE


        }
        holder.editText.setOnClickListener {
            val context = holder.itemView.context
            val builder = AlertDialog.Builder(context)
            val input = EditText(context)
            input.setText(list[position])
            builder.setView(input)

            builder.setPositiveButton("OK") { dialog, which ->
                val newText = input.text.toString()
                if (newText.isNotEmpty()) {
                    list[position] = newText
                    notifyItemChanged(position)
                } else {
                    Toast.makeText(context, "Text cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }
            builder.show()

        }
        holder.itemText.setOnClickListener {
            // Handle item click
        }
    }

}



