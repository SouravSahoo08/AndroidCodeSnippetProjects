package com.example.toastdemo

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    fun click(view: View?) {
        val nameEditText = findViewById<View>(R.id.nameEditText) as EditText
        Toast.makeText(this, "Hi " + nameEditText.text.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}