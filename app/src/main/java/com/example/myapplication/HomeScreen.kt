package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.myapplication.bottom_navbar_screen.FirstFragment
import com.example.myapplication.bottom_navbar_screen.SecondFragment
import com.example.myapplication.bottom_navbar_screen.ThirdFragment
import com.example.myapplication.data_model.GridViewModel
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.fragment_third.*

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        bottomNavigationView.setOnItemSelectedListener { item ->
                println(item.itemId)
            when(item.itemId) {
                R.id.person -> setCurrentScreen(FirstFragment())
                R.id.hotspot -> setCurrentScreen(SecondFragment())
                R.id.cloud -> setCurrentScreen(ThirdFragment())
            }
            true
        }

    }

    private fun setCurrentScreen(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.myFragment, fragment).commit()
        }
    }

}