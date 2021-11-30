package com.axel.googlemapintergration.activity.classModel

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

//model class for the clustering to happen

class ClusterModel(val hospital:String,val latLng: LatLng):ClusterItem {
    override fun getPosition(): LatLng {
       return latLng
    }

    override fun getTitle(): String? {
        return hospital
    }

    override fun getSnippet(): String? {

        return ""
    }
}
