package com.example.wander;

public class ObjectiveItem {
    private String name;
    private int image;
    private String description;
    private int points;
    private double lat;
    private double lng;
    private boolean found;
    private String when;
    private String hint;
    private boolean hintUsed;

    ObjectiveItem(String name, int image, int points, double lat, double lng) {
        this.name = name;
        this.image = image;
        this.points = points;
        this.lat = lat;
        this.lng = lng;
        this.found = false;
        this.when = "Not Found";
        this.hintUsed = false;
    }

    public String getName() { return name; }
    public int getImage() { return image; }
    public String getDescription() { return description; }
    public int getPoints() { return points; }
    public double getLat() { return lat; }
    public double getLong() { return lng; }
    public boolean getFound() { return found; }
    public String getWhen() { return when; }
    public String getHint() { return hint; }
    public boolean hintUsed() { return hintUsed; }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setFound(boolean found) { this.found = found; }
    public void setWhen(String when) { this.when = when; }
    public void setHint(String hint) { this.hint = hint; }
    public void setHintUsed(boolean hintUsed) { this.hintUsed = hintUsed; }
}
