package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second_screen.*

class SecondScreen : AppCompatActivity() {
    companion object {
        const val SECOND_DATA = "data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        val data = intent.getStringExtra(SECOND_DATA) // getting passed data from previous screen
        Log.d("data", data.toString())
        println("buttonField going to initialize")
        buttonField?.setOnClickListener {
            val username:String = usernameField?.editableText.toString()
            val password:String = passwordField?.editableText.toString()
            if(username.trim() == "codematrix" && password.trim() == "1234"){
                Toast.makeText(this,"You have logged in successfully",Toast.LENGTH_SHORT).show()
                println(HomeScreen::class.java)
                val intent = Intent(this,HomeScreen::class.java)
                startActivity(intent)
            } else {
                val toast = Toast(this)
                toast.duration = Toast.LENGTH_SHORT
                toast.setText("Wrong password")
                toast.show()
            }
        }
        gridViwNavigate.setOnClickListener {
            val navigateIntent = Intent(this,GridViewActivity::class.java)
            intent.putExtra("title","GridView Screen")
            startActivity(navigateIntent)
        }


    }

}