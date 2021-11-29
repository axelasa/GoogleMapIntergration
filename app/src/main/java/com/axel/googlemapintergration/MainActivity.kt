package com.axel.googlemapintergration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // we need to type cast the mapFragment as supportMapFragment, hence the conversion in the line below.
        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync {
            googleMap = it

            //values for the location you are looking for.
            val location1 = LatLng(-1.287257425320237, 36.80839998049184)
            googleMap.addMarker(MarkerOptions().position(location1).title("Liaison House"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,18f))
            //to have multiple locations just copy, paste, and update the values above.
        }

    }
}