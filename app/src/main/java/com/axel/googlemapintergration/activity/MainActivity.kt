package com.axel.googlemapintergration.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axel.googlemapintergration.R
import com.axel.googlemapintergration.activity.classModel.ClusterModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager

class MainActivity : AppCompatActivity() {

    private lateinit var mapFragment: SupportMapFragment
   private lateinit var googleMap: GoogleMap

   private var hospitalList:ArrayList<ClusterModel> = ArrayList()

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
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,15f))
            //to have multiple locations just copy, paste, and update the values above.
        }

        //the functions below are used when you want to use Clusters in your Maps.
        mapFragment.getMapAsync{
            setUpClusterManager(googleMap)
        }
    }
    private fun setUpClusterManager(googleMap: GoogleMap) {

        val clusterManager = ClusterManager<ClusterModel>(this,googleMap)
        googleMap?.setOnCameraIdleListener(clusterManager)

        hospitalList= getAllItems()

        clusterManager.addItems(hospitalList)
        clusterManager.cluster()
    }
    private fun getAllItems(): ArrayList<ClusterModel> {

        val arrayList:ArrayList<ClusterModel> = ArrayList()

        val location2 = LatLng(-1.286325978658972, 36.8067236748431)//LiaisonGroup
        val location3 = LatLng(-1.287257425320237, 36.80839998049184)// Liaison House
        val location4 = LatLng(-1.2906112814710435, 36.81097116600183)// Bishop House
        val location5 = LatLng(-1.2893462611729325, 36.81113987813852)// Shell
        val location6 = LatLng(-1.2855997532411203, 36.80797383159688)// Vienna Court
        val location7 = LatLng(-1.2928607556259597, 36.810554465074)// NTSA Offices
        val location8 = LatLng(-1.2899612770105062, 36.812067620918604)// NSSF
        val location9 = LatLng(-1.2906966523346914, 36.81173136406425)// Department Of Civil Registration
        val location10 = LatLng(-1.2914950595887393, 36.81173136406425)// Kenya Universities And Collages
        val location11 = LatLng(-1.292797723517337, 36.80845285973426)//4th Ngong Avenue Towers
        val location12 = LatLng(-1.2918942631217207, 36.813811953350594)//Milimani Law Courts

        val hospital1 = ClusterModel("LiaisonGroup",location2)
        val hospital2 = ClusterModel("Liaison House",location3)
        val hospital3 = ClusterModel("Bishop House",location4)
        val hospital4 = ClusterModel("Shell",location5)
        val hospital5 = ClusterModel("Vienna Court",location6)
        val hospital6 = ClusterModel("NTSA Offices",location7)
        val hospital7 = ClusterModel("NSSF",location8)
        val hospital8 = ClusterModel("Department Of Civil Registration",location9)
        val hospital9 = ClusterModel(" Kenya Universities And Collages",location10)
        val hospital10 = ClusterModel("4th Ngong Avenue Towers",location11)
        val hospital11 = ClusterModel("Milimani Law Courts",location12)

        arrayList.add(hospital1)
        arrayList.add(hospital2)
        arrayList.add(hospital3)
        arrayList.add(hospital4)
        arrayList.add(hospital5)
        arrayList.add(hospital6)
        arrayList.add(hospital7)
        arrayList.add(hospital8)
        arrayList.add(hospital9)
        arrayList.add(hospital10)
        arrayList.add(hospital11)

        return arrayList
    }
}