package com.example.input_controls

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener { view: View->
            val next = Intent(this,MainActivity::class.java)
            startActivity(next)
        }
    }
}