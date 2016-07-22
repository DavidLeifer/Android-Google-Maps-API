package org.letsplaywaves.www.maptest;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import android.util.Log;

import static com.google.android.gms.maps.GoogleMap.*;

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
        LatLng L7 = new LatLng(44.805367, -91.510235);
        LatLng L8 = new LatLng(44.796954, -91.499661);

        mMap.addMarker(new MarkerOptions()
                .position(EC)
                .title("Cache-memory clear")
                .snippet("Click and drage some markers around")
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_AZURE)))
                .showInfoWindow();
        //mMap.setOnMarkerClickListener(new OnMarkerClickListener(){
        //        @Override
        //        public boolean onMarkerClick(Marker marker) {
        //        marker.setVisible(false);
        //        Toast.makeText(getApplicationContext(),"You clicked her",Toast.LENGTH_LONG).show();
        //        return false;
        //    }
        //});
        mMap.setOnMarkerDragListener(new OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker){
                Log.d("Drag","Drag Started Fam");
            }

            @Override
            public void onMarkerDrag(Marker marker) {
                Log.d("Drag","Drag Dragging Fam");
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Log.d("Drag","Drag Ended Hopefully");

                LatLng latLng = marker.getPosition();
                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;
                Toast.makeText(getApplicationContext(),"Latitude : "+latitude+"\nLongitude : "+longitude,Toast.LENGTH_LONG).show();
            }
        });
        mMap.addMarker(new MarkerOptions()
                .position(L)
                .title("Memory Fading")
                .snippet("wut")
                .draggable(true)
                .alpha(.3f)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions()
                .position(L2)
                .title("Nostalgia circa 2011-2012")
                .snippet("exercise the daemons")
                .draggable(true)
                .alpha(.4f)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions()
                .position(L3)
                .title("Nearly Blocked")
                .snippet("exercise the daemons")
                .draggable(true)
                .alpha(.1f)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_RED)));
        mMap.addMarker(new MarkerOptions()
                .position(L4)
                .title("Started to Slide")
                .snippet("stop being melodramatic")
                .draggable(true)
                .alpha(.6f)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions()
                .position(L5)
                .title("Slowly faded")
                .snippet("I get weird when I code")
                .draggable(true)
                .alpha(.5f)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions()
                .position(L6)
                .title("Dominance Asserted")
                .snippet("I get weird when I code")
                .draggable(true)
                .alpha(.69f)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(L7)
                .title("Almost forgotten")
                .snippet("You're insane")
                .draggable(true)
                .alpha(.1f)
                .icon(BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_VIOLET)));

        mMap.addMarker(new MarkerOptions()
                .position(L8)
                .title("GAC")
                .snippet("Stop being so melodramatic")
                .draggable(true)
                .anchor(0.5f, 0.5f)
                .rotation(180.0f));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(EC));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(MAP_TYPE_TERRAIN);

    }
}
