package com.example.wander;

public class ObjectiveItem {
    private String location;
    private String when;
    private String image;
    private boolean found;

    ObjectiveItem(String location, String when, boolean found, String image) {
        this.location = location;
        this.when = when;
        this.found = found;
        this.image = image;
    }

    public String getLocation() { return location; }
    public String getWhen() { return when; }
    public boolean getFound() { return found; }
    public String getImage() { return image; }

    public void setAll(String location, String when, boolean found, String image) {
        this.location = location;
        this.when = when;
        this.found = found;
        this.image = image;
    }
}
