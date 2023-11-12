package com.uniftec.mapas;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng borgesMedeiros = new LatLng(-30.045205, -51.229446);
        mMap.addMarker(new MarkerOptions().position(borgesMedeiros).title("Rua Borges de Medeiros - POA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(borgesMedeiros));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(borgesMedeiros,15.0f));

        ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        mMap.setMyLocationEnabled(true);

        mMap.getUiSettings().setZoomControlsEnabled(true);//sinal de + e -
        mMap.getUiSettings().setMyLocationButtonEnabled(true);//leva o mapa para a localização atual
        mMap.getUiSettings().setCompassEnabled(true);//habilita uma bússula
        mMap.getUiSettings().setZoomGesturesEnabled(true);//zoom com o dedo
        mMap.getUiSettings().setRotateGesturesEnabled(true);//permite girar com a mão
        mMap.getUiSettings().setAllGesturesEnabled(true);
    }
}
