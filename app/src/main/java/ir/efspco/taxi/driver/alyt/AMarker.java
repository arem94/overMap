package ir.efspco.taxi.driver.alyt;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class AMarker {

    public double lat;
    public double lng;
    public View view;
    public int gravity;
    public int defZoom;
    public boolean zoomWithMap = false;
    public boolean rotateWithMap = false;
    public float bearing = 0f;

    public AMarker(Context context, double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
        ImageView marker = new ImageView(context);
        marker.setImageResource(android.R.drawable.ic_menu_myplaces);
        this.view = marker;
        this.gravity = 2;
    }



    public AMarker setView(View view) {
        this.view = view;
        return this;
    }

    public AMarker setBearing(int bearing) {
        this.bearing = bearing;
        return this;
    }

    public AMarker setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public AMarker setDefZoom(int defZoom) {
        this.defZoom = defZoom;
        return this;
    }

    public AMarker setEnableZoomWithMap(boolean zoomWithMap) {
        this.zoomWithMap = zoomWithMap;
        return this;
    }

    public AMarker setEnableRotateWithMap(boolean rotateWithMap) {
        this.rotateWithMap = rotateWithMap;
        return this;
    }



}
