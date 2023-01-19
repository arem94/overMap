package ir.efspco.taxi.driver.alyt;

import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;

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


    public static void addMarker(AMarker aMarker, RelativeLayout layout){
        markers.add(aMarker);
        layout.addView(aMarker.view);
    }

    public static void refreshMarkers(GoogleMap map, View layout) {
        Projection projection = map.getProjection();

        LatLng topLeft = projection.getVisibleRegion().farLeft;
        LatLng topRight = projection.getVisibleRegion().farRight;
        LatLng c = map.getCameraPosition().target;
        LatLng bottomRight = new LatLng((c.latitude - topLeft.latitude) + c.latitude, (c.longitude - topLeft.longitude) + c.longitude);
        LatLng bottomLeft = new LatLng((c.latitude - topRight.latitude) + c.latitude, (c.longitude - topRight.longitude) + c.longitude);
        float zoom = map.getCameraPosition().zoom;
        float bearing = map.getCameraPosition().bearing;

        for (AMarker marker : markers) {
            APoint geo = Geometry.findRelativePosition(new APoint(marker.lat, marker.lng)
                    , toAPoint(topLeft)
                    , toAPoint(topRight)
                    , toAPoint(bottomLeft)
                    , toAPoint(bottomRight)
            );

            if (geo != null) {

                floatMarker(marker,zoom,bearing , geo,layout.getWidth(),layout.getHeight());
             if(marker.view.getVisibility()==View.GONE)
                marker.view.setVisibility(View.VISIBLE);

            }else{
                marker.view.setVisibility(View.GONE);
            }
        }


    }

    private static APoint toAPoint(LatLng latLng) {
        return new APoint(latLng.latitude, latLng.longitude);
    }
}
