package au.com.hyperionstudios.travelapp.model;

import java.util.List;

public class Destination {

    String title;
    String descirpiton;
    Location location;
    String type;
    String tripDuration;
    String transportation;
    int numberOfFBookings;
    String featutedImageUrl;
    List<String> galleryUrls;
    List<Review> reviews;
    List<Place> places;

    public Destination(String title, String descirpiton, Location location, String type, String tripDuration, String transportation, int numberOfFBookings, String featutedImageUrl, List<String> galleryUrls, List<Review> reviews, List<Place> places) {
        this.title = title;
        this.descirpiton = descirpiton;
        this.location = location;
        this.type = type;
        this.tripDuration = tripDuration;
        this.transportation = transportation;
        this.numberOfFBookings = numberOfFBookings;
        this.featutedImageUrl = featutedImageUrl;
        this.galleryUrls = galleryUrls;
        this.reviews = reviews;
        this.places = places;
    }

    public int numberOfPlaces(){
        return places.size();
    }

    public String getTitle() {
        return title;
    }

    public String getDescirpiton() {
        return descirpiton;
    }

    public Location getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getTripDuration() {
        return tripDuration;
    }

    public String getTransportation() {
        return transportation;
    }

    public int getNumberOfFBookings() {
        return numberOfFBookings;
    }

    public String getFeatutedImageUrl() {
        return featutedImageUrl;
    }

    public List<String> getGalleryUrls() {
        return galleryUrls;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Place> getPlaces() {
        return places;
    }
}
