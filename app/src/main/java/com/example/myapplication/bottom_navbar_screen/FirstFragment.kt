package com.example.myapplication.bottom_navbar_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Handler
import android.widget.*
import com.example.myapplication.HomeScreen
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_first.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                println(progress)
                rangeView.text = "Seekbar Count: $progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                println(seekBar)
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                println(seekBar)
            }
        })
        checkBox1.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                    println(v?.isSelected)
                    Toast.makeText(context as HomeScreen, "You CheckBox1 is enable: ${v?.isSelected}",Toast.LENGTH_SHORT).show()
              var i = progressBar.progress
                Thread(Runnable {
                    while (i<100){
                        i+=1
                        handler.post(Runnable {
                            progressBar.progress = i
                            header_title!!.text = "Progress Bar: ${i}%"
                        })
                        try {
                            Thread.sleep(100)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }
                    progressBar.visibility = View.VISIBLE
                }).start()
            }

        })
        checkBox2.setOnClickListener {
            println(view.isSelected)
            Toast.makeText(context as HomeScreen, "You CheckBox2 is enable: ${view.isSelected}",Toast.LENGTH_SHORT).show()
        }
        radio_button_group.setOnClickListener {
            val selectedId = radio_button_group.checkedRadioButtonId
            println(selectedId)
            val clicked = when(selectedId){
                 R.id.radio_button_1 -> "First Radio Button Clicked"
                 R.id.radio_button_2 -> "second radio button Clicked"
                 R.id.radio_button_3 -> "third radio button Clicked"
                else -> "not selected any one"
            }
            println(clicked)
        }
        // Create the instance of ArrayAdapter
        // having the list of courses
        val array:Array<String> = arrayOf("C","C++","Python","Kotlin","Dart","JavaScript")
        val context = context as HomeScreen
        val spinnerAdapter: ArrayAdapter<*> = ArrayAdapter(context, android.R.layout.simple_spinner_item,array)
        // set simple layout resource file
        // for each item of spinner
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = spinnerAdapter

        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}