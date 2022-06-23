package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fourth_screen.*
import java.util.*

class FourthScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_screen)
        val today = Calendar.getInstance()
        date_picker_calender.init(today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DATE)
        ) { view, year, month, day ->
            textView3.text = "Selected Date:(Calender): $day/$month/$year"
            Toast.makeText(
                this,
                "Selected Date:(Calender): $day/$month/$year",
                Toast.LENGTH_SHORT
            ).show()
        }
        date_picker_spinner.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DATE)
        ) { view, year, month, day ->
            textView5.text = "Selected Date:(Spinner): $day/$month/$year"
            Toast.makeText(
                this,
                "Selected Date:(Calender): $day/$month/$year",
                Toast.LENGTH_SHORT
            )
        }
       drawerBackIcon.setOnClickListener {
           onBackPressed();
       }

    }
    }