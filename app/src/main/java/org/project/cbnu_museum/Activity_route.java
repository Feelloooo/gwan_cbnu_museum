package org.project.cbnu_museum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class Activity_route extends AppCompatActivity implements MapView.POIItemEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        //actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("오시는 길");

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

        //전화걸기 아이콘
        Button button1 = findViewById(R.id.direction_phone);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"043-261-2902"));
                startActivity(intent);
            }
        });
        //자동차 길찾기 아이콘
        Button button2 = findViewById(R.id.direction_car);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "kakaomap://route?sp=&ep=" + "36.62775104579331, 127.45535206324857" + "&by=CAR";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        //대중교통 길찾기 아이콘
        Button button3 = findViewById(R.id.direction_bus);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "kakaomap://route?sp=&ep=" + "36.62775104579331, 127.45535206324857" + "&by=PUBLICTRANSIT";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        //도보 길찾기 아이콘
        Button button4 = findViewById(R.id.direction_walk);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "kakaomap://route?sp=&ep=" + "36.62775104579331, 127.45535206324857" + "&by=FOOT";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });

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