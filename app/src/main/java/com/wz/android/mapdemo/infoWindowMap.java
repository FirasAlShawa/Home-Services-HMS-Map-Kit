package com.wz.android.mapdemo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.Marker;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

public class infoWindowMap implements HuaweiMap.InfoWindowAdapter {

    private Context context;

    public infoWindowMap(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.infowindow,null);
        ImageView infoIcon= view.findViewById(R.id.infoIcon);
        TextView infoTitle= view.findViewById(R.id.infoTitle);
        TextView infoPhone= view.findViewById(R.id.infoPhone);
        Button infoCallBtn= view.findViewById(R.id.infoCallBtn);

        mLocation location =(mLocation)marker.getTag();

        Picasso.get().load(location.getIcon()).into(infoIcon);
        infoTitle.setText(location.getName());
        infoPhone.setText(location.getPhone());

        return view;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }
}
