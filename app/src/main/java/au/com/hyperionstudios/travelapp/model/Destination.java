package au.com.hyperionstudios.travelapp.model;

import java.util.List;

public class Destination {

    String title;
    String featuredImageUrl;
    List<Place> places;

    public Destination(String title, String featuredImageUrl, List<Place> places) {
        this.title = title;
        this.featuredImageUrl = featuredImageUrl;
        this.places = places;
    }

    int getPlacesCount(){
        return places.size();
    }

    public String getTitle() {
        return title;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public List<Place> getPlaces() {
        return places;
    }
}
