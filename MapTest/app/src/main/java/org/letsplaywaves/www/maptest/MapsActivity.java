package org.letsplaywaves.www.maptest;

import android.support.v4.app.FragmentActivity;
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
        //MapsInitializer.initialize(Context);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Eau Claire and move the camera
        LatLng EC = new LatLng(44.801214, -91.513916);
        LatLng L = new LatLng(44.797899, -91.505432);
        LatLng L2 = new LatLng(44.798691, -91.508082);
        LatLng L3 = new LatLng(44.797549, -91.508511);
        LatLng L4 = new LatLng(44.804249, -91.503222);
        LatLng L5 = new LatLng(44.806213, -91.505368);
        LatLng L6 = new LatLng(44.799727, -91.495476);
        mMap.addMarker(new MarkerOptions()
                .position(EC)
                .title("Uno")
                .draggable(true)
                .alpha(.7f);
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(new MarkerOptions()
                .position(L)
                .title("Dos")
                .draggable(true)
                .alpha(.3f));
        mMap.addMarker(new MarkerOptions()
                .position(L2)
                .title("Tres")
                .draggable(true)
                .alpha(.4f));
        mMap.addMarker(new MarkerOptions()
                .position(L3)
                .title("I can't")
                .draggable(true)
                .alpha(.1f));
        mMap.addMarker(new MarkerOptions()
                .position(L4)
                .title("speak")
                .draggable(true)
                .alpha(.9f));
        mMap.addMarker(new MarkerOptions()
                .position(L5)
                .title("the spainish")
                .draggable(true)
                .alpha(.7f));
        mMap.addMarker(new MarkerOptions()
                .position(L6)
                .title("here's a marker")
                .draggable(true)
                .alpha(.2f));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(EC));
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

    }
}
