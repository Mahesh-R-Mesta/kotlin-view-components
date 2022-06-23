package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.tab_bar_screens.FirstTabBarView
import com.example.myapplication.tab_bar_screens.SecondTabBarView
import com.example.myapplication.tab_bar_screens.ThirdTabBarView
import com.example.myapplication.utility.MyViewPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_bar_screen.*
import java.util.zip.Inflater

class TabBarScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_bar_screen)
//        val toolBar = findViewById<Toolbar>(R.id.myToolBar)
//        setSupportActionBar(toolBar)
        val adpater = MyViewPagerAdapter(supportFragmentManager)
        adpater.addFragmentTab(FirstTabBarView(),"Tab1")
        adpater.addFragmentTab(SecondTabBarView(),"tab2")
        adpater.addFragmentTab(ThirdTabBarView(),"tab3")
        tabViewPage.adapter = adpater
        tabs.setupWithViewPager(tabViewPage)
        toolbarButton.setOnClickListener {
          val popup =  PopupMenu(this, toolbarButton)
            popup.menuInflater.inflate(R.menu.bottom_nav_menu,popup.menu)
            popup.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    return true
                }
            })
            popup.show();
        }

    }

}