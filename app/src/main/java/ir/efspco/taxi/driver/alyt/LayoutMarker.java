package ir.efspco.taxi.driver.alyt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class LayoutMarker {
    Context context;
    View rootLayout;

    public LayoutMarker(Context context, View rootLayout, int tilePixel) {
        this.tilePixel = tilePixel;
        this.context = context;
        this.rootLayout = rootLayout;
    }

    public LayoutMarker(Context context, View rootLayout) {
        this.context = context;
        this.rootLayout = rootLayout;
    }

    private ArrayList<AMarker> markers = new ArrayList<>();

    private void floatMarker(AMarker marker, float zoom, float bearing, APoint point, int screenWidth, int screenHigh) {

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

    private Listener listener;

    public interface Listener {
        public void click(AMarker marker);
    }

    public void addMarkerClickListener(Listener listener) {
        this.listener = listener;
    }

    @SuppressLint("ClickableViewAccessibility")
    public void addMarker(AMarker aMarker, RelativeLayout layout) {
        markers.add(aMarker);
        layout.addView(aMarker.view);

    }


    public void sync(GoogleMap map) {
        Projection projection = map.getProjection();
        LatLng topLeft = projection.getVisibleRegion().farLeft;
        LatLng topRight = projection.getVisibleRegion().farRight;
        LatLng c = map.getCameraPosition().target;
        sync(topLeft, topRight, c, map.getCameraPosition().zoom, map.getCameraPosition().bearing);
    }

    private int tilePixel = 256;
    private final int earthRadius = 6378160;
    private static double angle = 0;

    public double getMeterPerPixel(double lat, double zoom) {
        double pixelsPerTile = tilePixel * ((double) context.getResources().getDisplayMetrics().densityDpi / 160);
        double numTiles = Math.pow(2, zoom);
        double earthPerimeter = earthRadius * 2 * Math.PI;
        double metersPerTile = Math.cos(Math.toRadians(lat)) * earthPerimeter / numTiles;
        return metersPerTile / pixelsPerTile;
    }

    public void sync(double cLat, double cLng, float zoom, float bearing) {
        try {
            double metersPerPx = getMeterPerPixel(cLat, zoom);

            double[] latlng = destinationPoint(cLat, cLng, 0,
                    (float) (rootLayout.getHeight() / 2 * metersPerPx) / 1000);
            double[] latlng1 = destinationPoint(cLat, cLng, 90,
                    (float) (rootLayout.getWidth() / 2 * metersPerPx) / 1000);
            double[] latlng2 = destinationPoint(cLat, cLng, -90,
                    (float) (rootLayout.getWidth() / 2 * metersPerPx) / 1000);


            LatLng topRight = new LatLng(latlng[0], latlng1[1]);
            LatLng topLeft = new LatLng(latlng[0], latlng2[1]);
            LatLng center = new LatLng(cLat, cLng);

            if (bearing != 0) {
                double dist = distance(latlng[0], latlng1[1], cLat, cLng) / 1000;
                if (angle == 0) {
                    double chord = Math.sqrt(Math.pow(rootLayout.getWidth(), 2) + Math.pow(rootLayout.getHeight(), 2));
                    angle = toDeg(Math.acos(rootLayout.getWidth() / chord));
                }
                double[] tr = destinationPoint(cLat, cLng, 90 - angle + bearing, dist);
                double[] tl = destinationPoint(cLat, cLng, -(90 - angle - bearing), dist);

                topRight = new LatLng(tr[0], tr[1]);
                topLeft = new LatLng(tl[0], tl[1]);
            }
            sync(topLeft, topRight, center, zoom, bearing);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sync(LatLng topLeft, LatLng topRight, LatLng c, float zoom, float bearing) {

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

        int[] params = new int[2];

//        rootLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                Log.i("AMIRRRRR1", "onTouch: " + motionEvent.getY());
//                Log.i("AMIRRRRR12", "onTouch: " + motionEvent.getAction());
//                float y = motionEvent.getY();
//                float x = motionEvent.getX();
//
//                for (AMarker a : markers) {
//                    a.view.getLocationOnScreen(params);
//                    Log.i("AMIRRRRR44", "onTouch: " + x+"  "+y);
//                    Log.i("AMIRRRRR44", "onTouch: " + (params[0]+(a.view.getWidth()/2))+"  "+(params[0] - (a.view.getWidth()/2)));
//                    Log.i("AMIRRRRR44", "onTouch: " + params[0]+"  "+params[1]);
//                    Log.i("AMIRRRRR44", "onTouch: " +(params[0] +  a.view.getWidth())+"  "+ (params[1] +  a.view.getHeight()));
//
//                    if (x <= params[0]+(a.view.getWidth()/2) && x >= (params[0] - (a.view.getWidth()/2))) {
//                        if (y >= params[1] && y <= (params[1] +  a.view.getHeight())) {
//                            Log.d("tag", "this touch is in button area");
//                            // do what you want to do when touch/click comes in button area
//                        }
//                    }
//                }
//                return false;
//            }
//        });


    }

    private APoint toAPoint(LatLng latLng) {
        return new APoint(latLng.latitude, latLng.longitude);
    }

    private double toDeg(double rad) {
        return rad * 180 / Math.PI;
    }

    private double toRad(double deg) {
        return deg * Math.PI / 180;
    }

    /**
     * calculate new location by another location and distance
     * you must passed a location and distance to another location with bearing and you get new location
     *
     * @param lat
     * @param lng
     * @param brng
     * @param dist
     * @return
     */
    private double[] destinationPoint(double lat, double lng, double brng, double dist) {
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

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     * <p>
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     *
     * @returns Distance in Meters
     */
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
}
