package org.letsplaywaves.www.maptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class MapsActivity extends Activity implements OnMapReadyCallback {

    static final LatLng UWEC= new LatLng(44.798363, -91.501223);
    static final LatLng dave = new LatLng(44.802147, -91.509752);
    static final LatLng MADRID = new LatLng(40.4378271,-3.6795367);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap map) {

        map.addMarker(new MarkerOptions().position(UWEC).title("UWEC").snippet("Hi chief, best 4-5 years of your life !"));
        map.addMarker(new MarkerOptions().position(dave).title("dave").snippet("This isn't where I live !"));

        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.android)).position(MADRID,200f,200f);

        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                View v = getLayoutInflater().inflate(R.layout.info_window, null);

                LatLng latLng = marker.getPosition();
                ImageView icon = (ImageView)v.findViewById(R.id.icon);
                TextView title = (TextView)v.findViewById(R.id.title);
                TextView snippet = (TextView)v.findViewById(R.id.snippet);
                TextView lat = (TextView) v.findViewById(R.id.lat);
                TextView lng = (TextView) v.findViewById(R.id.lng);

                title.setText(marker.getTitle());
                snippet.setText(marker.getSnippet());
                if(marker.getTitle().equals("dave")){
                    icon.setImageResource(R.drawable.dave);
                }else if(marker.getTitle().equals("UWEC")){
                    icon.setImageResource(R.drawable.uwec);
                }

                lat.setText("Latitude: " + latLng.latitude);
                lng.setText("Longitude: "+ latLng.longitude);

                return v;
            }
        });

    }

}