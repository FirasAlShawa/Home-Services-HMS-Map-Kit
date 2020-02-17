package com.wz.android.mapdemo;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {

    private static final long serialVersionUID =1L;

    String title;
    ArrayList<mLocation> locations;

    public Category(String title, ArrayList<mLocation> locations) {
        this.title = title;
        this.locations = locations;
    }

    public Category(String title) {
        this.title = title;
        this.locations = new ArrayList<>();
    }

    public void AddLocation(Double lat,Double lng,int icon,String phone) {
        this.locations.add(new mLocation(lat,lng,this.title,phone,icon));
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<mLocation> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<mLocation> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                '}';
    }
}
