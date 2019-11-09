package com.example.wander;

public class ObjectiveItem {
    private String location;
    private String when;
    private boolean found;

    ObjectiveItem(String location, String when, boolean found) {
        this.location = location;
        this.when = when;
        this.found = found;
    }

    public String getLocation() { return location; }
    public String getWhen() { return when; }
    public boolean getFound() { return found; }

    public void setAll(String location, String when, boolean found) {
        this.location = location;
        this.when = when;
        this.found = found;
    }
}
