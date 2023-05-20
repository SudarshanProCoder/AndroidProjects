package com.example.map;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.map.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            LatLng latLng = new LatLng(19.1450028841289, 72.99565483416906);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Om Arcade");
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f));

            //circle

            mMap.addCircle(new CircleOptions().center(latLng).radius(1000).fillColor(Color.GREEN).strokeColor(Color.DKGRAY));

            //polygon

           // mMap.addPolygon(new PolygonOptions().add(latLng));
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(@NonNull LatLng latLng) {

                    mMap.addMarker(new MarkerOptions().position(latLng).title("Clicked Here"));
                    Geocoder geocoder = new Geocoder(MapsActivity.this);

                    try {
                        ArrayList<Address>  addresses = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                        Toast.makeText(MapsActivity.this, addresses.get(0).getAddressLine(0).toString(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

    }
}