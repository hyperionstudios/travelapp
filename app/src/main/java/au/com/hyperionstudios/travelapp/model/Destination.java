package au.com.hyperionstudios.travelapp.model;

import java.util.List;

public class Destination {

    int id;
    String title;
    String featuredImageUrl;
    int placesCount;

    public Destination(int id, String title, String featuredImageUrl, int placesCount) {
        this.id = id;
        this.title = title;
        this.featuredImageUrl = featuredImageUrl;
        this.placesCount = placesCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public int getPlacesCount() {
        return placesCount;
    }
}
