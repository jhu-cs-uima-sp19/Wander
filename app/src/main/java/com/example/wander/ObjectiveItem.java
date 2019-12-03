package com.example.wander;

public class ObjectiveItem {
    private String name;
    private double lat;
    private double lng;
    private String when;
    private String description;
    private int image;
    private boolean found;

    ObjectiveItem(String name, double lat, double lng, String when, boolean found, int image) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.when = when;
        this.found = found;
        this.image = image;
    }

    public String getName() { return name; }
    public double getLat() { return lat; }
    public double getLong() { return lng; }
    public String getWhen() { return when; }
    public String getDescription() { return description; }
    public boolean getFound() { return found; }
    public int getImage() { return image; }

    public void setDescription(String description) {
        this.description = description;
    }
}
