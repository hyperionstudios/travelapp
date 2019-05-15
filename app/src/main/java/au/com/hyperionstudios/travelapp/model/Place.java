package au.com.hyperionstudios.travelapp.model;

import java.util.List;

public class Place {

    private String title;
    private String descirpiton;
    private Location location;
    private String type;
    private String tripDuration;
    private String transportation;
    private int numberOfFBookings;
    private String featuredImageUrl;
    private List<String> galleryUrls;
    private List<Review> reviews;

    public Place(String title, String descirpiton, Location location, String type, String tripDuration, String transportation, int numberOfFBookings, String featuredImageUrl, List<String> galleryUrls, List<Review> reviews) {
        this.title = title;
        this.descirpiton = descirpiton;
        this.location = location;
        this.type = type;
        this.tripDuration = tripDuration;
        this.transportation = transportation;
        this.numberOfFBookings = numberOfFBookings;
        this.featuredImageUrl = featuredImageUrl;
        this.galleryUrls = galleryUrls;
        this.reviews = reviews;
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

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public List<String> getGalleryUrls() {
        return galleryUrls;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
