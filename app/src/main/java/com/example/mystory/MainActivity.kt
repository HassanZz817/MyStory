package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textViewEmail:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("username")
        connectViews()
        textViewEmail.text = email
    }
    private fun connectViews(){
        textViewEmail = findViewById(R.id.tvEmail)
    }
}