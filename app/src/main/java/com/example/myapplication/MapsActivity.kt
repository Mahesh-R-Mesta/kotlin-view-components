package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplication.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.activity_maps.*
import java.io.IOException

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        const val MAP_TYPE = ""
    }
    private var mapType =""
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    var address: List<Address> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        mapType = intent.getStringExtra(MAP_TYPE)?:"location"
        Log.d("mapview type:",mapType)
        val geoCoder:Geocoder = Geocoder(this)
        val googleSearchView = findViewById<SearchView>(R.id.googleSearchView)

        googleSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val  searchKey = googleSearchView.query.toString()
                if(searchKey.isNotEmpty()){
                    try {
                        address  = geoCoder.getFromLocationName(query,1)
                    } catch (e:IOException) {
                        println(e.message)
                    }
                     val firstAddress:Address = address.get(0)
                     val location:LatLng = LatLng(firstAddress.latitude, firstAddress.longitude)
                    setLocation(latLong = location,"query")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if(mapType == "location"){
            googleSearchView.visibility = View.VISIBLE
        }
        if(mapType=="polyline"){
            setPolylineMap(googleMap)
        } else if(mapType == "polygon"){
            setPolygon(googleMap)
        }
        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private fun setPolylineMap(googleMap: GoogleMap){
        val location1 = LatLng(14.6196,74.8441)
        val location2 = LatLng(12.9716,77.5946)
        val location3 = LatLng(12.2958,76.6394)
        googleMap.addPolyline(PolylineOptions().add(location1,location2,location3).width(5.0F).color(Color.RED).geodesic(true))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location1));
    }

    private fun setPolygon(googleMap: GoogleMap){
        val location1 = LatLng(14.6196,74.8441)
        val location2 = LatLng(12.9716,77.5946)
        val location3 = LatLng(12.2958,76.6394)
        googleMap.addPolygon(PolygonOptions().add(location1,location2,location3).strokeWidth(1.0F).fillColor(Color.GREEN))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location1));
    }

    fun setLocation(latLong:LatLng,name:String) {
        mMap.clear()
     mMap.addMarker(MarkerOptions().position(latLong).title("Your Marker"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLong))
    }
}