package com.example.wander;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private Location currentLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        final SharedPreferences sharedPref = this.getActivity().getApplicationContext().getSharedPreferences("gameState", Context.MODE_PRIVATE);
        final Gson gson = new Gson();

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map); //use SupportMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());

                // Add a marker at all found locations
                String response = sharedPref.getString("objectiveList", "");
                ArrayList<ObjectiveItem>  objectiveItems = gson.fromJson(response,
                        new TypeToken<List<ObjectiveItem>>(){}.getType());
                for (ObjectiveItem obj: objectiveItems) {
                    if (obj.getFound()) {
                        LatLng temp = new LatLng(obj.getLat(), obj.getLong());
                        mMap.addMarker(new MarkerOptions().position(temp).title(obj.getName()));
                    }
                }

                //requestPermissions(FINE_LOCATION_PERMS, 1);
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                    fusedLocationClient.getLastLocation()
                            .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                    // Got last known location. In some rare situations this can be null.
                                    if (location != null) {
                                        currentLocation = location;
                                        //Log.d("myTag", ""+location.getLongitude());
                                    }
                                }
                            });

                }
                //mMap.setMyLocationEnabled(true);

            }
        });


        return rootView;
    }
}