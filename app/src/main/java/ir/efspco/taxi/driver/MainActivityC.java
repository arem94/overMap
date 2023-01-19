//package ir.efspco.taxi.driver;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//import ir.efspco.taxi.driver.alyt.AMarker;
//import ir.efspco.taxi.driver.alyt.HandelMarker;
//
//public class MainActivityC extends AppCompatActivity implements OnMapReadyCallback {
//    ProgressBar btn;
//    Button btn1;
//    Button btn2;
//    Button btn3;
//    Button btn4;
//    Button btn5;
//    Button btn6;
//    Button btn7;
//    Button btn9;
//    Button btn8;
//    Button btn10;
//    Button btn11;
//    Button btn12;
//    Button btn13;
//    Button btn14;
//    RelativeLayout options;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//        btn = findViewById(R.id.btn);
////        btn1 = findViewById(R.id.btn1);
////        btn2 = findViewById(R.id.btn2);
////        btn3 = findViewById(R.id.btn3);
////        btn4 = findViewById(R.id.btn4);
////        btn5 = findViewById(R.id.btn5);
////        btn6 = findViewById(R.id.btn6);
////        btn7 = findViewById(R.id.btn7);
////        btn8 = findViewById(R.id.btn8);
////        btn9 = findViewById(R.id.btn9);
////        btn10= findViewById(R.id.btn10);
////        btn11 = findViewById(R.id.btn11);
////        btn12 = findViewById(R.id.btn12);
////        btn13 = findViewById(R.id.btn13);
////        btn14 = findViewById(R.id.btn14);
//        options = findViewById(R.id.options);
////        btn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                LatLng topLeft = _map.getProjection().getVisibleRegion().farLeft;
////                LatLng topRight = _map.getProjection().getVisibleRegion().farRight;
////
////                LatLng c = _map.getCameraPosition().target;
////                LatLng bottomRight = new LatLng((c.latitude - topLeft.latitude) + c.latitude, (c.longitude - topLeft.longitude) + c.longitude);
////                LatLng bottomLeft = new LatLng((c.latitude - topRight.latitude) + c.latitude, (c.longitude - topRight.longitude) + c.longitude);
////
////
////                _map.addMarker(new MarkerOptions().position(topLeft).icon(BitmapDescriptorFactory
////                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
////                _map.addMarker(new MarkerOptions().position(topRight).icon(BitmapDescriptorFactory
////                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
////                _map.addMarker(new MarkerOptions().position(c).icon(BitmapDescriptorFactory
////                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
////                _map.addMarker(new MarkerOptions().position(bottomRight).icon(BitmapDescriptorFactory
////                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
////                _map.addMarker(new MarkerOptions().position(bottomLeft).icon(BitmapDescriptorFactory
////                        .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
////
////
////            }
////        });
//    }
//
//    GoogleMap _map;
//
//    @Override
//    public void onMapReady(@NonNull GoogleMap map) {
//
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.39, 59.56), 14));
//        map.getCameraPosition();
//
//        _map = map;
//        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
////        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));        _map.addMarker(new MarkerOptions().position(new LatLng(36.37, 59.56)).icon(BitmapDescriptorFactory
////                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
//
////        new AMarker(this, 36.25, 59.56).setGravity(5);
//
//        View view = LayoutInflater
//                .from(MainActivityC.this)
//                .inflate(R.layout.origin_marker, null, false);
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setView(view).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.56).setBearing(90).setEnableRotateWithMap(true));
////        addMarker(new AMarker(getApplicationContext(), 36.32, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.393, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.394, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.395, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.396, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.397, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.398, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.399, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.561).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.562).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.563).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.564).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.565).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.566).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.567).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.568).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.569).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.560).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.5611).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.5612).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.5613).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.5614).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.5615).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.5617).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.5618).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.329, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.349, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.359, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.369, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.398, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.399, 59.56).setBearing(90));
////        addMarker(new AMarker(getApplicationContext(), 36.39, 59.561).setBearing(90));
//
//        AMarker aMarker = new AMarker(getApplicationContext(), 36.37, 59.56).setBearing(90);
//        HandelMarker.addMarker(aMarker, options);
//        map.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
//            @Override
//            public void onCameraMove() {
////                map.getCameraPosition();
////                LatLng northeast = map.getProjection().getVisibleRegion().latLngBounds.northeast;
////                LatLng southwest = map.getProjection().getVisibleRegion().latLngBounds.southwest;
////                LatLng northwest = new LatLng(southwest.latitude, northeast.longitude);
////                LatLng southeast = new LatLng(northeast.latitude, southwest.longitude);
//
////                if(inPage(new LatLng(36.37,59.56))){
////                    btn.setVisibility(View.VISIBLE);
////                }else{
////                    btn.setVisibility(View.GONE);
////                }
////                Projection projection = map.getProjection();
//
////                LatLng topLeft = projection.getVisibleRegion().farLeft;
////                LatLng topRight = projection.getVisibleRegion().farRight;
////                LatLng c = _map.getCameraPosition().target;
////                LatLng bottomRight = new LatLng((c.latitude - topLeft.latitude) + c.latitude, (c.longitude - topLeft.longitude) + c.longitude);
////                LatLng bottomLeft = new LatLng((c.latitude - topRight.latitude) + c.latitude, (c.longitude - topRight.longitude) + c.longitude);
////
//
//                HandelMarker.refreshMarkers(map, options);
////                APoint geo = Geometry.findRelativePosition(new APoint(aMarker.lat,aMarker.lng)
////                        , toAPoint(topLeft)
////                        , toAPoint(topRight)
////                        , toAPoint(bottomLeft)
////                        , toAPoint(bottomRight)
////                );
//
////                if (geo != null) {
////                    HandelMarker.floatMarker(aMarker, _map.getCameraPosition().zoom, _map.getCameraPosition().bearing, geo,options.getWidth(),options.getHeight());
////                    Log.i("TAG", "onCameraMove: "+geo.x+" "+geo.y);
////                }
////                float bearing = _map.getCameraPosition().bearing;
////                float zoom = _map.getCameraPosition().zoom;
////                Projection projection1 = _map.getProjection();
////                for (AMarker m : markers) {
////                    new Runnable() {
////                        @Override
////                        public void run() {
////                            floatMarker(m, projection1,zoom,bearing);
////                        }
////                    }.run();
////
////                }
////                UpdateMarker u = new UpdateMarker(_map,markers);
////                u.execute();
////                floatMarker(btn1, new LatLng(36.36, 59.56));
////                floatMarker(btn2, new LatLng(36.37, 59.54));
////                floatMarker(btn3, new LatLng(36.37, 59.51));
////                floatMarker(btn5, new LatLng(36.31, 59.52));
////                floatMarker(btn4, new LatLng(36.332, 59.56));
////                floatMarker(btn6, new LatLng(36.32, 59.4));
////                floatMarker(btn7, new LatLng(34.37, 59.59));
////                floatMarker(btn8, new LatLng(36.27, 59.54));
////                floatMarker(btn9, new LatLng(36.17, 59.16));
////                floatMarker(btn10, new LatLng(36.327, 59.53));
////                floatMarker(btn11, new LatLng(36.317, 59.587));
////                floatMarker(btn12, new LatLng(36.537, 59.66));
////                floatMarker(btn13, new LatLng(36.375, 59.06));
////                floatMarker(btn14, new LatLng(36.327, 59.96));
////                floatMarker(btn1,new LatLng(33.7,59.56));
//            }
//        });
//    }
//
////    private APoint toAPoint(LatLng latLng) {
////        return new APoint(latLng.latitude, latLng.longitude);
////    }
//
////    private void addMarker(AMarker marker) {
////        markers.add(marker);
////        options.addView(marker.view);
////    }
//
////    ArrayList<AMarker> markers = new ArrayList<>();
//
////    private boolean inPage(double lat, double lng, Projection projection) {
////        LatLng topLeft = projection.getVisibleRegion().farLeft;
////        LatLng topRight = projection.getVisibleRegion().farRight;
////        LatLng c = _map.getCameraPosition().target;
////        LatLng bottomRight = new LatLng((c.latitude - topLeft.latitude) + c.latitude, (c.longitude - topLeft.longitude) + c.longitude);
////        LatLng bottomLeft = new LatLng((c.latitude - topRight.latitude) + c.latitude, (c.longitude - topRight.longitude) + c.longitude);
////
////        double maxLat = topLeft.latitude;
////        double maxLng = topLeft.longitude;
////        double minLat = topLeft.latitude;
////        double minLng = topLeft.longitude;
////
////        if (topRight.latitude > maxLat) {
////            maxLat = topRight.latitude;
////        }
////        if (bottomRight.latitude > maxLat) {
////            maxLat = bottomRight.latitude;
////        }
////        if (bottomLeft.latitude > maxLat) {
////            maxLat = bottomLeft.latitude;
////        }
////
////        if (topRight.latitude < minLat) {
////            minLat = topRight.latitude;
////        }
////        if (bottomRight.latitude < minLat) {
////            minLat = bottomRight.latitude;
////        }
////        if (bottomLeft.latitude < minLat) {
////            minLat = bottomLeft.latitude;
////        }
////
////
////        if (topRight.longitude > maxLng) {
////            maxLng = topRight.longitude;
////        }
////        if (bottomRight.longitude > maxLng) {
////            maxLng = bottomRight.longitude;
////        }
////        if (bottomLeft.longitude > maxLng) {
////            maxLng = bottomLeft.longitude;
////        }
////
////        if (topRight.longitude < minLng) {
////            minLng = topRight.longitude;
////        }
////        if (bottomRight.longitude < minLng) {
////            minLng = bottomRight.longitude;
////        }
////        if (bottomLeft.longitude < minLng) {
////            minLng = bottomLeft.longitude;
////        }
////
////
////        if (lat > minLat && lat < maxLat) {
////            if (lng > minLng && lng < maxLng)
////                return true;
////        }
////        return false;
////    }
////
////    private void floatMarker(AMarker marker, Projection projection, float zoom, float bearing) {
////        if (inPage(marker.lat, marker.lng, projection)) {
////            marker.view.setVisibility(View.VISIBLE);
////        } else {
////            marker.view.setVisibility(View.GONE);
////            return;
////        }
////        LatLng position = new LatLng(marker.lat, marker.lng);
////        Point point = projection.toScreenLocation(position);
////
////        float defZoom = 14f;
////        if (zoom > defZoom) {
////            defZoom = zoom - defZoom + 1;
////        } else {
////            defZoom = (float) Math.pow(0.5, defZoom - zoom);
////        }
////
////        int x = marker.view.getWidth() / 2;
////        int y = marker.view.getHeight() / 2;
////        switch (marker.gravity) {
////            case 1:
////                x = 0;
////                y = marker.view.getHeight();
////                break;
////            case 2:
////                x = marker.view.getWidth() / 2;
////                y = marker.view.getHeight();
////                break;
////            case 3:
////                x = marker.view.getWidth();
////                y = marker.view.getHeight();
////                break;
////            case 4:
////                x = 0;
////                y = marker.view.getHeight() / 2;
////                break;
////            case 6:
////                x = marker.view.getWidth();
////                y = marker.view.getHeight() / 2;
////                break;
////            case 7:
////                x = 0;
////                y = 0;
////                break;
////            case 8:
////                x = marker.view.getWidth() / 2;
////                y = 0;
////                break;
////            case 9:
////                x = marker.view.getWidth();
////                y = 0;
////                break;
////            default:
////                break;
////        }
//////
////        marker.view.setPivotX(x);
////        marker.view.setPivotY(y);
////        marker.view.setTranslationX(point.x - x);
////        marker.view.setTranslationY(point.y - y);
////        if (marker.zoomWithMap) {
////            marker.view.setScaleX(defZoom);
////            marker.view.setScaleY(defZoom);
////        }
////        if (marker.rotateWithMap)
////            marker.view.setRotation(marker.bearing - bearing);
////
////
////    }
//}