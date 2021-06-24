package org.project.cbnu_museum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import net.daum.mf.map.api.*;

public class Activity_route extends AppCompatActivity implements MapView.POIItemEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        //mapview
        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        //marker
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("충북대학교 박물관");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(36.62775104579331, 127.45535206324857));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(36.62775104579331, 127.45535206324857), 2, true);
        mapView.setPOIItemEventListener(this);

    }

    //implements MapView.POIItemEventListener Override
    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {
    }
    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {
        String uri = "kakaomap://place?id=8117063";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
    }
    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {
    }
}