package au.com.hyperionstudios.travelapp.model;

import java.util.List;

public class Destination {

    int id;
    String title;
    String featuredImageUrl;

    public Destination( int id, String title, String featuredImageUrl, List<Place> places) {
        this.id = id;
        this.title = title;
        this.featuredImageUrl = featuredImageUrl;
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

}
