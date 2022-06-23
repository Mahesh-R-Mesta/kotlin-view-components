package com.example.myapplication
import android.content.Intent
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("activity-cycle:","onCreate Called")
        var count = 0
        val countText:TextView = findViewById(R.id.countTextView)
        countTextView.text = count.toString()
        button_count.setOnClickListener {
            count+=1

            countTextView.text = count.toString()
        }
    }

    companion object {
        val STATE_KEY = "state"
        val TEXT_KEY = "textState"
    }

    override fun onStart() {
        Log.d("activity-cycle:","onStart Called")
        super.onStart()
    }

    override fun onRestart() {
        Log.d("activity-cycle:","onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.d("activity-cycle","onResume")
        super.onResume()
    }
    override fun onDestroy() {
        Log.d("activity-cycle:","onDestroy")
        super.onDestroy()
    }

    override fun onPause() {
        Log.d("activity-cycle:","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("activity-cycle:","onStop")
        super.onStop()
    }
    // This callback is called only when there is a saved instance that is previously saved by using
   // onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
   // other state here, possibly usable after onStart() has completed.
   // The savedInstanceState Bundle is same as the one used in onCreate().
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val data:String? = savedInstanceState.getString(TEXT_KEY)
        println(data)
        super.onRestoreInstanceState(savedInstanceState)
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.run {
            putString(STATE_KEY,"This is State")
            putString(TEXT_KEY,"save text or data") // you can save the instance activity data just before destroy call
        }
        super.onSaveInstanceState(outState, outPersistentState)
    }

    fun onFloatingBarClick(view: View) {
        Toast.makeText(this, "Navigating To next Page", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,SecondScreen::class.java)
        intent.putExtra(SecondScreen.SECOND_DATA,"learn Kotlin")
        startActivity(intent)
    }
}