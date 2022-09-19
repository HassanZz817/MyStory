package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

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
//        checkFields()
    }
    private fun connectViews(){
        editTextPassword = findViewById(R.id.etPassword)
        editTextUsername = findViewById(R.id.etUsername)
        buttonLogin = findViewById(R.id.btnLogin)
        checkBoxView = findViewById(R.id.checkbox1)
    }
    private fun login() {
        val arr: ArrayList<User> = ArrayList()

        arr.add(User("test@test.com", "1234"))
        arr.add(User("a", "1"))
        arr.add(User("black@ass.com", "123"))

        buttonLogin.setOnClickListener{
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            val user = User(username,password)

            for (userArray in arr){
                if (userArray.email.toString() == user.email.toString()
                    && userArray.Password == user.Password){
                     finish()
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    intent.putExtra("username",userArray.email.toString())
                    startActivity(intent)
                    break
                }else{
                    Toast.makeText(this,
                        "Check your data",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun checkFields(){
              buttonLogin.setOnClickListener {
                  if (editTextUsername.text.isEmpty()
                  ) {
                      editTextUsername.error = ("Enter your email")
                  }else if (editTextPassword.text.isEmpty()) {
                      editTextPassword.error = ("Enter your Password")
                  }else if (!checkBoxView.isChecked){
                      checkBoxView.error = ("you must agree with the terms and conditions")
                  } else {
                      Toast.makeText(
                          this,
                          "Success",
                          Toast.LENGTH_SHORT
                      ).show()


                  }
              }
       }
    }
