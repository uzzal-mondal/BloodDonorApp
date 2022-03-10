package com.blood.blooddonorapp.map

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.blood.blooddonorapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by Android Dev on 11-Mar-22 Mar, 2022
 */
class MapDialog(context: Context): Dialog(context),OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_map)

      //  val gmap:GoogleMap =
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0
        val sydney = LatLng(-34.0, 151.0)
        map.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}