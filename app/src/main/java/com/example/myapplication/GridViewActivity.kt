package com.example.myapplication

import MainAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myapplication.data_model.GridViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_grid_view.*
import kotlinx.android.synthetic.main.activity_grid_view.view.*

class GridViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navigation_view)
         val toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav1 ->{
                    Toast.makeText(this,"Clicked on Profile",Toast.LENGTH_SHORT).show()
                    Toast.makeText(this,"Clicked on Logout",Toast.LENGTH_SHORT).show()
                    val tabScreenIntent = Intent(this,TabBarScreen::class.java)
                    startActivity(tabScreenIntent)
                }
                R.id.nav2 -> {
                    val screenIntent = Intent(this@GridViewActivity, fifthScreen::class.java)
                    startActivity(screenIntent)
                }
                R.id.nav3 -> {
                    val fourthScreen = Intent(this,FourthScreen::class.java)
                    startActivity(fourthScreen)
                }
                R.id.nav4 -> {
                    Toast.makeText(this,"Clicked on Location",Toast.LENGTH_SHORT).show()
                    val mapScreen = Intent(this, MapsActivity::class.java)
                    mapScreen.putExtra(MapsActivity.MAP_TYPE, "location")
                    startActivity(mapScreen)
                }
                R.id.nav5 -> {
                    val polyMap = Intent(this,MapsActivity::class.java)
                    polyMap.putExtra(MapsActivity.MAP_TYPE, "polyline")
                    startActivity(polyMap)
                }
                R.id.nav6 -> {
                    val polyGon = Intent(this, MapsActivity::class.java)
                    polyGon.putExtra(MapsActivity.MAP_TYPE,"polygon")
                    startActivity(polyGon)
                }
            }
            true
        }


        imageView2.setOnClickListener({
            onBackPressed()
        })

        var gridView:GridView = findViewById(R.id.gridview)
        val arrayTitle:Array<String> = arrayOf("Taj Mahal","Mountain","Nature","Lord","World")
        val arrayImage:IntArray = intArrayOf(R.drawable.taj,R.drawable.mountain,R.drawable.tree,R.drawable.mahadev,R.drawable.world)
        gridview.adapter = MainAdapter(this, arrayTitle, arrayImage)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer_menu,menu)
        super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}