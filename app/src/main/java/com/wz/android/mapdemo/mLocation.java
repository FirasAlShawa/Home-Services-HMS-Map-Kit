package com.wz.android.mapdemo;
import com.huawei.hms.maps.model.LatLng;
import java.io.Serializable;

public class mLocation implements Serializable {

    private static final long serialVersionUID =1L;

    Double lat;
    Double lng;
    String name;
    String phone;
    int icon;

    public mLocation() {
        this.lat = 0.0;
        this.lng = 0.0;
        this.name = "Default";
    }

    public mLocation(Double lat, Double lng, String name, String phone, int icon) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.phone = phone;
        this.icon = icon;
    }

    public LatLng getLatLng(){
        return new LatLng(this.lat,this.lng);
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
