/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.wz.android.mapdemo;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.Color;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LocationSettingsStatusCodes;
import com.huawei.hms.location.SettingsClient;
import com.huawei.hms.maps.CameraUpdate;
import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.Circle;
import com.huawei.hms.maps.model.CircleOptions;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.maps.util.LogM;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "MapViewDemoActivity";

    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    private static final int REQUEST_CODE = 100;

    private static final LatLng LAT_LNG = new LatLng(31.2304, 121.4737);

    private HuaweiMap hmap;

    private MapView mMapView;

    private Marker mMarker;

    private Circle mCircle;

    private static final String[] RUNTIME_PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET
    };

    ArrayList<mLocation> locations;
    Category category;
    Intent intent;
    Boolean alreadyExecuted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogM.d(TAG, "map onCreate:");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intent = getIntent();

        category = (Category) intent.getExtras().getSerializable("Category");
        locations = category.getLocations();


        if (!hasPermissions(this, RUNTIME_PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, RUNTIME_PERMISSIONS, REQUEST_CODE);
        }



        // get mapView by layout view
        mMapView = findViewById(R.id.mapView);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView.onCreate(mapViewBundle);

        // get map by async method
        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(HuaweiMap map) {
        Log.d(TAG, "onMapReady: ");

        // after call getMapAsync method ,we can get HuaweiMap instance in this call back method
        hmap = map;
        hmap.setMyLocationEnabled(true);

        for (mLocation location : locations) {
            int height = 150;
            int width = 150;
            BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(location.getIcon());
            Bitmap b=bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
            MarkerOptions options =new MarkerOptions()
                    .position(location.getLatLng())
                    .snippet("Phone :" +location.getPhone())
                    .title(location.getName())
                    .icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
            infoWindowMap windowMap = new infoWindowMap(MainActivity.this);
            map.setInfoWindowAdapter(windowMap);
            Marker marker = map.addMarker(options);
            marker.setTag(location);
            marker.showInfoWindow();
        }
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(31.9539, 35.9106),10));

        // move camera by CameraPosition param ,latlag and zoom params can set here
        CameraPosition build = new CameraPosition.Builder().target(new LatLng(24.746914, 46.693813)).zoom(5).build();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(build);
        hmap.animateCamera(cameraUpdate);
        hmap.setMaxZoomPreference(20);
        hmap.setMinZoomPreference(1);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
//        if(!alreadyExecuted) {
//            requestLocationUpdatesWithCallback();
//            alreadyExecuted = true;
//        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


}
