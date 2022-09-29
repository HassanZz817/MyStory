package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AddStoryActivity : AppCompatActivity() {
    lateinit var editTextTitle:TextView
    lateinit var editTextSubtitle:TextView
    lateinit var editTextDesc:TextView
     lateinit var btnAddStory :Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_stroy)

        connectViews()
        fieldsValidation()


    }
    private fun connectViews(){
        editTextTitle = findViewById(R.id.etTitle)
        editTextSubtitle = findViewById(R.id.etSubtitle)
        editTextDesc = findViewById(R.id.etDesc)
        btnAddStory = findViewById(R.id.btnAddStory)
    }
    private fun fieldsValidation(){
        btnAddStory.setOnClickListener{
            val title = editTextTitle.text
            val subTitle = editTextSubtitle.text
            val desc = editTextDesc.text

            when {
                title.isEmpty() -> {
                    editTextTitle.error = "Enter title"
                }
                subTitle.isEmpty() -> {
                    editTextSubtitle.error = "Enter subtitle"
                }
                desc.isEmpty() -> {
                    editTextDesc.error = "Enter Description"
                }
                else -> {
                    // Add story now all filed are valid
                    this.finish()
                    val i = Intent(this,MainActivity::class.java)
                    i.putExtra("title",title)
                    i.putExtra("subtitle",subTitle)
                    i.putExtra("desc",desc)
                    startActivity(i)

                }
            }

        }
    }
}