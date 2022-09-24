package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbarView: Toolbar
    lateinit var navigationView: NavigationView
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("username")
        connectViews()
        setSupportActionBar(toolbarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()
        updateEmailInHeader(email!!)
        drawerClick()
    }
    private fun connectViews(){

        drawerLayout = findViewById(R.id.drawer)
        toolbarView = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navView)
        recyclerView = findViewById(R.id.storiesRecyclerView)
    }
    private fun setupDrawer(){
        val toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun updateEmailInHeader(email:String){
        val headerView = navigationView.getHeaderView(0)
        val textViewEmail = headerView.findViewById<TextView>(R.id.etEmail)
        textViewEmail.text = email

    }
    private fun drawerClick(){
        navigationView.setNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.home -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                    true


                }
                R.id.logout -> {
                    finish()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    true
                }  else -> true

            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout.openDrawer(GravityCompat.START)
                true
            } else -> true
        }
    }
}