package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    lateinit var editTextUsername:EditText
    lateinit var editTextPassword:EditText
    lateinit var buttonLogin:Button
    lateinit var checkBoxView: CheckBox




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        connectViews()
        login()
    }
    private fun connectViews(){
        editTextPassword = findViewById(R.id.etPassword)
        editTextUsername = findViewById(R.id.etUsername)
        buttonLogin = findViewById(R.id.btnLogin)
        checkBoxView = findViewById(R.id.checkbox1)
    }
    private fun login(){
        val arr:ArrayList<User> = ArrayList()

        arr.add(User("test@test.com","1234"))
        arr.add(User("t@gmail.com","123321"))
        arr.add(User("black@ass.com","123321"))


        buttonLogin.setOnClickListener{
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            val user = User(username,password)

            for (userArray in arr){
                if (userArray.email == user.email &&
                    userArray.Password == user.Password){
                    Toast.makeText(this,"Welcome" +
                            " ${user.email}",Toast.LENGTH_SHORT).show()

                }else{
                   Toast.makeText(this,
                       "Enter your data",Toast.LENGTH_SHORT).show()

                }
            }
        }

//        buttonLogin.setOnClickListener{
//            if (editTextUsername.text.isEmpty()||
//                editTextPassword.text.isEmpty() ||
//                checkBoxView.isChecked != true
//            ){
//                Toast.makeText(this,"Enter your data",Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
//
//            }
//        }
    }
}
