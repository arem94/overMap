package ir.efspco.taxi.driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import org.neshan.mapsdk.MapView;

import ir.efspco.taxi.driver.alyt.AMarker;
import ir.efspco.taxi.driver.alyt.LayoutMarker;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    ProgressBar btn;
    RelativeLayout options;


    boolean googleActive = false;
    LayoutMarker layoutMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapGoogle);
        mapFragment.getMapAsync(this);
        btn = findViewById(R.id.btn);
        options = findViewById(R.id.options);
//                    double metersPerPx = 156543.03392 * Math.cos(map.getCameraTargetPosition().getLatitude() * Math.PI / 180) / Math.pow(2, map.getZoom());

        MapView nMap = findViewById(R.id.map);
        nMap.moveCamera(new org.neshan.common.model.LatLng(centerLat, centerLng), 0);
        nMap.setZoom(zoom, 0);


        layoutMarker = new LayoutMarker(getApplicationContext(),options);
        layoutMarker.addMarkerClickListener(new LayoutMarker.Listener() {
            @Override
            public void click(AMarker marker) {
                Log.i("TAG", "click: "+marker.lat+"   "+marker.lng);
            }
        });
        Button btnAddMarker = findViewById(R.id.btnAddMarker);
        RelativeLayout googleMapLayout = findViewById(R.id.googleMapLayout);
        Button btnChangeMap = findViewById(R.id.btnChangeMap);
        btnChangeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleActive = !googleActive;

                if (googleActive) {
                    nMap.setVisibility(View.GONE);
                    googleMapLayout.setVisibility(View.VISIBLE);
                    CameraPosition position = new CameraPosition(new LatLng(centerLat, centerLng), zoom, 0, bearing);
                    gMap.moveCamera(CameraUpdateFactory.newCameraPosition(position));
                } else {
                    if (bearing < 180) {
                        nMap.setBearing(-bearing, 0);
                    } else {
                        nMap.setBearing(360-bearing, 0);
                    }
                    nMap.setVisibility(View.VISIBLE);
                    googleMapLayout.setVisibility(View.GONE);
                    nMap.moveCamera(new org.neshan.common.model.LatLng(centerLat, centerLng), 0);
                    nMap.setZoom(zoom, 0);

                }
            }
        });

        if (googleActive) {
            nMap.setVisibility(View.GONE);
            googleMapLayout.setVisibility(View.VISIBLE);
        } else {
            nMap.setVisibility(View.VISIBLE);
            googleMapLayout.setVisibility(View.GONE);
        }
        btnAddMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AMarker aMarker = new AMarker(getApplicationContext(), centerLat, centerLng).setBearing(90).setEnableZoomWithMap(true).setEnableRotateWithMap(true);
                    layoutMarker.addMarker(aMarker, options);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                width = options.getWidth();
                height = options.getHeight();

                nMap.setOnCameraMoveListener(new MapView.OnCameraMoveListener() {
                    @Override
                    public void onCameraMove() {
                        if (!googleActive) {
                            bearing = nMap.getBearing();

                            if (bearing <= 0) {
                                bearing = Math.abs(bearing);
                            } else {
                                bearing = 360 - bearing;
                            }
                            centerLat = nMap.getCameraTargetPosition().getLatitude();
                            centerLng = nMap.getCameraTargetPosition().getLongitude();
                            zoom = nMap.getZoom();

                            layoutMarker.sync(centerLat,
                                    centerLng,
                                    zoom,
                                    bearing);


//                            map.moveCamera(new org.neshan.common.model.LatLng(centerLat, centerLng), zoom);
                        }
                    }
                });
            }
        }, 1000);

    }


    int height;
    int width;
    GoogleMap _map;

    double centerLat = 36.37;
    double centerLng = 59.56;
    float zoom = 14;
    float bearing = 14;


    GoogleMap gMap;

    @Override
    public void onMapReady(@NonNull GoogleMap map) {

        gMap = map;
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(centerLat, centerLng), zoom));

        map.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                if (googleActive) {
                    layoutMarker.sync(gMap);
                    centerLat = gMap.getCameraPosition().target.latitude;
                    centerLng = gMap.getCameraPosition().target.longitude;
                    bearing = gMap.getCameraPosition().bearing;
                    zoom = gMap.getCameraPosition().zoom;
                    Log.i("TAG", "onCameraMove: "+bearing );
//                    refreshMarker(gMap.getCameraPosition().target.latitude, gMap.getCameraPosition().target.longitude, gMap.getCameraPosition().zoom, gMap.getCameraPosition().bearing);
//                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(centerLat, centerLng), zoom));
                }
//                HandelMarker.refreshMarkers(map, options);
            }
        });
    }


//    private double toDeg(double rad) {
//        return rad * 180 / Math.PI;
//    }
//
//    private double toRad(double deg) {
//        return deg * Math.PI / 180;
//    }
//
//    private double[] destinationPoint(double lat, double lng, double brng, double dist) {
//        dist = dist / 6371;
//        brng = toRad(brng);
//
//        double lat1 = toRad(lat);
//        double lon1 = toRad(lng);
//
//        double lat2 = Math.asin(Math.sin(lat1) * Math.cos(dist) +
//                Math.cos(lat1) * Math.sin(dist) * Math.cos(brng));
//
//        double lon2 = lon1 + Math.atan2(Math.sin(brng) * Math.sin(dist) *
//                        Math.cos(lat1),
//                Math.cos(dist) - Math.sin(lat1) *
//                        Math.sin(lat2));
//        return new double[]{toDeg(lat2), toDeg(lon2)};
//
//    }

//    int tilePixel = 512;
//    int earthRadius = 6378160;
//    float f = (float) (earthRadius * 2 * Math.PI / tilePixel);

//    private void refreshMarker(double cLat, double cLng, float zoom, float bearing) {
//        centerLat = cLat;
//        centerLng = cLng;
//        this.zoom = zoom;
//        try {
//            double metersPerPx = f * Math.cos(cLat * Math.PI / 180) / Math.pow(2, zoom);
//            double[] latlng = destinationPoint(cLat, cLng, 0,
//                    (float) ((height - tilePixel) / 2 * metersPerPx) / 1000);
//            double[] latlng1 = destinationPoint(cLat, cLng, 90,
//                    (float) ((width - tilePixel / 2) / 2 * metersPerPx) / 1000);
//            double[] latlng2 = destinationPoint(cLat, cLng, -90,
//                    (float) ((width - tilePixel / 2) / 2 * metersPerPx) / 1000);
//            LatLng topRight = new LatLng(latlng[0], latlng1[1]);
//            LatLng topLeft = new LatLng(latlng[0], latlng2[1]);
//            LatLng center = new LatLng(cLat, cLng);
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
////                    HandelMarker.refreshMarkers(topLeft, topRight, center, zoom, bearing, options);
//                }
//            });
//        } catch (Exception e) {
//
//        }
//    }

}