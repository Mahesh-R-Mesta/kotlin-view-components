package com.example.myapplication.bottom_navbar_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import com.example.myapplication.HomeScreen
import com.example.myapplication.R
import com.example.myapplication.constants.Posts
import com.example.myapplication.constants.RetrofitHelper
import com.example.myapplication.data_model.JsonData
import com.example.myapplication.data_model.ListViewModel
import com.example.myapplication.utility.ListViewAdapter
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val context = context as HomeScreen
        val language:List<String> = listOf("c","c++","python","HTML","Dart","javascript")
        val users:MutableList<ListViewModel> = mutableListOf()

        val arrayAdapter: BaseAdapter = ListViewAdapter(context,users)
        listView.adapter = arrayAdapter
        val retroApi = RetrofitHelper.getInstance().create(Posts::class.java)
        var sortedList:MutableList<ListViewModel> = users;
        GlobalScope.launch {
            val result = retroApi.getAllPosts()
            val data:List<JsonData>? = result.body()
            if(data!=null && data.isNotEmpty()){
                for (each in data) {
                    users.add(ListViewModel(1,each.title,each.body))
                }
            }

            sortedList = users
        }




        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.isEmpty()==true){
                    sortedList = users
                }

                for(each in  users){
                    if(newText?.contains(each.title) == true){
                        sortedList.add(each)
                    }
                }
                setListView(sortedList)
                return  true
            }

        } )


        super.onStart()
    }


    fun setListView(cards: MutableList<ListViewModel> ){
        val arrayAdapter: BaseAdapter = ListViewAdapter( context as HomeScreen,cards)
        listView.adapter = arrayAdapter
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}