package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)
        val editText: EditText = findViewById(R.id.edit_text_id)
        val button: Button = findViewById(R.id.button_main)
        val myList: MutableList<String> = mutableListOf()



        val recyclerView: RecyclerView = findViewById(R.id.recycler_container)
        val myAdapter = MyAdapter(myList)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            val text = editText.text.toString()
            if(text.isNotEmpty()){
                myList.add(text)
                myAdapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }




    }
}

