package com.charleshested.kotlinintro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val descendantsOfEva: TextView = findViewById(R.id.textView4)
        val notDescendantsOfEva: TextView = findViewById(R.id.textView5)
        val isChildOfEve: TextView = findViewById(R.id.textView6)

        val persons = getPersons()

        descendantsOfEva.text = descendantsOfEva(persons).size.toString()
        notDescendantsOfEva.text = notDescendantsOfEva(persons).size.toString()
        isChildOfEve.text = persons.get(1).isChildOfEve().toString()

        Log.d("TAG MainActivity", "descendantsOfEva: " + descendantsOfEva(persons).size)
        Log.d("TAG MainActivity", "notDescendantsOfEva: " + notDescendantsOfEva(persons).size)
        Log.d("TAG MainActivity", "isChildOfEve 1: " + persons.get(1).isChildOfEve())
    }
}
