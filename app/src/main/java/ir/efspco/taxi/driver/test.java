//package ir.efspco.taxi.driver;
//
//import android.graphics.Point;
//import android.view.View;
//
//import com.google.android.gms.maps.model.LatLng;
//
//public class test {
//    private void floatMarker(AMarker marker) {
//        if (inPage(marker.lat, marker.lng)) {
//            marker.view.setVisibility(View.VISIBLE);
//        } else {
//            marker.view.setVisibility(View.GONE);
//            return;
//        }
//        LatLng position = new LatLng(marker.lat, marker.lng);
//        Point point = _map.getProjection().toScreenLocation(position);
//        float bearing = _map.getCameraPosition().bearing;
//        float zoom = _map.getCameraPosition().zoom;
//        float defZoom = 14f;
//        if (zoom > defZoom) {
//            defZoom = zoom - defZoom + 1;
//        } else {
//            defZoom = (float) Math.pow(0.5, defZoom - zoom);
//        }
//
//        int x = marker.view.getWidth() / 2;
//        int y = marker.view.getHeight() / 2;
//        switch (marker.gravity) {
//            case 1:
//                x = 0;
//                y = marker.view.getHeight();
//                break;
//            case 2:
//                x = marker.view.getWidth() / 2;
//                y = marker.view.getHeight();
//                break;
//            case 3:
//                x = marker.view.getWidth();
//                y = marker.view.getHeight();
//                break;
//            case 4:
//                x = 0;
//                y = marker.view.getHeight() / 2;
//                break;
//            case 6:
//                x = marker.view.getWidth();
//                y = marker.view.getHeight() / 2;
//                break;
//            case 7:
//                x = 0;
//                y = 0;
//                break;
//            case 8:
//                x = marker.view.getWidth() / 2;
//                y = 0;
//                break;
//            case 9:
//                x = marker.view.getWidth();
//                y = 0;
//                break;
//            default:
//                break;
//        }
//
//        marker.view.setPivotX(x);
//        marker.view.setPivotY(y);
//        marker.view.setTranslationX(point.x -x);
//        marker.view.setTranslationY(point.y -y);
//        if (marker.zoomWithMap) {
//            marker.view.setScaleX(defZoom);
//            marker.view.setScaleY(defZoom);
//        }
//        if (marker.rotateWithMap)
//            marker.view.setRotation(marker.bearing - bearing);
//
//
//    }
//
//}
