package ir.efspco.taxi.driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import ir.efspco.taxi.driver.alyt.AMarker;
import ir.efspco.taxi.driver.alyt.APoint;
import ir.efspco.taxi.driver.alyt.Geometry;
import ir.efspco.taxi.driver.alyt.HandelMarker;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    ProgressBar btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn9;
    Button btn8;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;
    Button btn14;
    RelativeLayout options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btn = findViewById(R.id.btn);
//        btn1 = findViewById(R.id.btn1);
//        btn2 = findViewById(R.id.btn2);
//        btn3 = findViewById(R.id.btn3);
//        btn4 = findViewById(R.id.btn4);
//        btn5 = findViewById(R.id.btn5);
//        btn6 = findViewById(R.id.btn6);
//        btn7 = findViewById(R.id.btn7);
//        btn8 = findViewById(R.id.btn8);
//        btn9 = findViewById(R.id.btn9);
//        btn10= findViewById(R.id.btn10);
//        btn11 = findViewById(R.id.btn11);
//        btn12 = findViewById(R.id.btn12);
//        btn13 = findViewById(R.id.btn13);
//        btn14 = findViewById(R.id.btn14);
        options = findViewById(R.id.options);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LatLng topLeft = _map.getProjection().getVisibleRegion().farLeft;
//                LatLng topRight = _map.getProjection().getVisibleRegion().farRight;
//
//                LatLng c = _map.getCameraPosition().target;
//                LatLng bottomRight = new LatLng((c.latitude - topLeft.latitude) + c.latitude, (c.longitude - topLeft.longitude) + c.longitude);
//                LatLng bottomLeft = new LatLng((c.latitude - topRight.latitude) + c.latitude, (c.longitude - topRight.longitude) + c.longitude);
//
//
//                _map.addMarker(new MarkerOptions().position(topLeft).icon(BitmapDescriptorFactory
//                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
//                _map.addMarker(new MarkerOptions().position(topRight).icon(BitmapDescriptorFactory
//                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
//                _map.addMarker(new MarkerOptions().position(c).icon(BitmapDescriptorFactory
//                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
//                _map.addMarker(new MarkerOptions().position(bottomRight).icon(BitmapDescriptorFactory
//                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//                _map.addMarker(new MarkerOptions().position(bottomLeft).icon(BitmapDescriptorFactory
//                        .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
//
//
//            }
//        });
    }

    GoogleMap _map;

    @Override
    public void onMapReady(@NonNull GoogleMap map) {

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.39, 59.56), 14));
        map.getCameraPosition();

        _map = map;
        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
//        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

//        new AMarker(this, 36.25, 59.56).setGravity(5);

        View view = LayoutInflater
                .from(MainActivity.this)
                .inflate(R.layout.origin_marker, null, false);
        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setView(view).setEnableRotateWithMap(true),options);
        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setView(view).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.32, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.393, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.394, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.395, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.396, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.397, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.398, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.399, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.561).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.562).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.563).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.564).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.565).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.566).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.567).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.568).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.569).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.560).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.5611).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.5612).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.5613).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.5614).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.5615).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.5617).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.5618).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.329, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.349, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.359, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.369, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.398, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.399, 59.56).setBearing(90),options);
//        HandelMarker.addMarker(new AMarker(getApplicationContext(), 36.39, 59.561).setBearing(90),options);

        AMarker aMarker = new AMarker(getApplicationContext(), 36.37, 59.56).setBearing(90);
        HandelMarker.addMarker(aMarker, options);
        map.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                HandelMarker.refreshMarkers(map, options);

            }
        });
    }

}