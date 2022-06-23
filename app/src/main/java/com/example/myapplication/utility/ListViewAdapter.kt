package com.example.myapplication.utility

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.data_model.ListViewModel
import com.squareup.picasso.Picasso

class ListViewAdapter(private val context:Activity,private val users:MutableList<ListViewModel>):BaseAdapter() {
    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater // from current screen take layout inflater for drawing
        val rowView = inflater.inflate(R.layout.listview_card,null, true) // it takes xml code and converts to class View for dynamically drawing
        val header = rowView.findViewById(R.id.header_title) as TextView
        val description = rowView.findViewById(R.id.description) as TextView
        val image = rowView.findViewById(R.id.profile_image) as ImageView
        header.text = users[position].title
        description.text = users[position].description
        Picasso.get().load("https://picsum.photos/200/300?random=${position}").into(image)
        return rowView
    }

}