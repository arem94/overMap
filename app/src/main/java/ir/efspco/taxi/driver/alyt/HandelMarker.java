package ir.efspco.taxi.driver.alyt;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.transition.MaterialSharedAxis;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ir.efspco.taxi.driver.alyt.AMarker;
import ir.efspco.taxi.driver.alyt.APoint;

public class HandelMarker {

    public static ArrayList<AMarker> markers = new ArrayList<>();

    public static void floatMarker(AMarker marker, float zoom, float bearing, APoint point, int screenWidth, int screenHigh) {

        float defZoom = 14f;
        if (zoom > defZoom) {
            defZoom = zoom - defZoom + 1;
        } else {
            defZoom = (float) Math.pow(0.5, defZoom - zoom);
        }

        int x = marker.view.getWidth() / 2;
        int y = marker.view.getHeight() / 2;
        switch (marker.gravity) {
            case 1:
                x = 0;
                y = marker.view.getHeight();
                break;
            case 2:
                x = marker.view.getWidth() / 2;
                y = marker.view.getHeight();
                break;
            case 3:
                x = marker.view.getWidth();
                y = marker.view.getHeight();
                break;
            case 4:
                x = 0;
                y = marker.view.getHeight() / 2;
                break;
            case 6:
                x = marker.view.getWidth();
                y = marker.view.getHeight() / 2;
                break;
            case 7:
                x = 0;
                y = 0;
                break;
            case 8:
                x = marker.view.getWidth() / 2;
                y = 0;
                break;
            case 9:
                x = marker.view.getWidth();
                y = 0;
                break;
            default:
                break;
        }
//
        marker.view.setPivotX(x);
        marker.view.setPivotY(y);
        marker.view.setTranslationX((float) ((point.x * screenWidth / 100) - x));
        marker.view.setTranslationY((float) ((point.y * screenHigh / 100) - y));
        if (marker.zoomWithMap) {
            marker.view.setScaleX(defZoom);
            marker.view.setScaleY(defZoom);
        }
        if (marker.rotateWithMap)
            marker.view.setRotation(marker.bearing - bearing);
    }


    public static void addMarker(AMarker aMarker, RelativeLayout layout) {
        markers.add(aMarker);
        layout.addView(aMarker.view);

    }

    public static void refreshMarkers(GoogleMap map, View rootLayout) {
        Projection projection = map.getProjection();
        LatLng topLeft = projection.getVisibleRegion().farLeft;
        LatLng topRight = projection.getVisibleRegion().farRight;
        LatLng c = map.getCameraPosition().target;
        refreshMarkers(topLeft, topRight, c, map.getCameraPosition().zoom, map.getCameraPosition().bearing, rootLayout);
    }

    static int tilePixel = 512;
    static int earthRadius = 6378160;
    static float f = (float) (earthRadius * 2 * Math.PI / tilePixel);

    public static void refreshMarkers(double cLat, double cLng, float zoom, float bearing, View rootLayout) {

        try {
            double metersPerPx = f * Math.cos(cLat * Math.PI / 180) / Math.pow(2, zoom);
            double[] latlng = destinationPoint(cLat, cLng, 0,
                    (float) ((rootLayout.getHeight() - tilePixel) / 2 * metersPerPx) / 1000);
            double[] latlng1 = destinationPoint(cLat, cLng, 90,
                    (float) ((rootLayout.getWidth() - tilePixel / 2) / 2 * metersPerPx) / 1000);
            double[] latlng2 = destinationPoint(cLat, cLng, -90,
                    (float) ((rootLayout.getWidth() - tilePixel / 2) / 2 * metersPerPx) / 1000);
            LatLng topRight = new LatLng(latlng[0], latlng1[1]);
            LatLng topLeft = new LatLng(latlng[0], latlng2[1]);
            LatLng center = new LatLng(cLat, cLng);
            refreshMarkers(topLeft, topRight, center, zoom, bearing, rootLayout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void refreshMarkers(LatLng topLeft, LatLng topRight, LatLng c, float zoom, float bearing, View rootLayout) {

        LatLng bottomRight = new LatLng((c.latitude - topLeft.latitude) + c.latitude, (c.longitude - topLeft.longitude) + c.longitude);
        LatLng bottomLeft = new LatLng((c.latitude - topRight.latitude) + c.latitude, (c.longitude - topRight.longitude) + c.longitude);

        for (AMarker marker : markers) {
            APoint geo = Geometry.findRelativePosition(new APoint(marker.lat, marker.lng)
                    , toAPoint(topLeft)
                    , toAPoint(topRight)
                    , toAPoint(bottomLeft)
                    , toAPoint(bottomRight)
            );

            if (geo != null) {
                floatMarker(marker, zoom, bearing, geo, rootLayout.getWidth(), rootLayout.getHeight());
                if (marker.view.getVisibility() == View.GONE)
                    marker.view.setVisibility(View.VISIBLE);
            } else {
                marker.view.setVisibility(View.GONE);
            }
        }


        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("AMIRRRRR", "onTouch: " + motionEvent.getX());
                Log.i("AMIRRRRR1", "onTouch: " + motionEvent.getY());

                return false;
            }
        });


    }

    private static APoint toAPoint(LatLng latLng) {
        return new APoint(latLng.latitude, latLng.longitude);
    }




    private static double toDeg(double rad) {
        return rad * 180 / Math.PI;
    }

    private static double toRad(double deg) {
        return deg * Math.PI / 180;
    }

    private static double[] destinationPoint(double lat, double lng, double brng, double dist) {
        dist = dist / 6371;
        brng = toRad(brng);

        double lat1 = toRad(lat);
        double lon1 = toRad(lng);

        double lat2 = Math.asin(Math.sin(lat1) * Math.cos(dist) +
                Math.cos(lat1) * Math.sin(dist) * Math.cos(brng));

        double lon2 = lon1 + Math.atan2(Math.sin(brng) * Math.sin(dist) *
                        Math.cos(lat1),
                Math.cos(dist) - Math.sin(lat1) *
                        Math.sin(lat2));
        return new double[]{toDeg(lat2), toDeg(lon2)};

    }


}
