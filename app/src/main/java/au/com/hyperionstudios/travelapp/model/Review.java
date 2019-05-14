package au.com.hyperionstudios.travelapp.model;

public class Review {
    int stars;
    String date;
    String reviewerName;
    String reviewerAvatar;
    String reviewText;

    public Review(int stars, String date, String reviewerName, String reviewerAvatar, String reviewText) {
        this.stars = stars;
        this.date = date;
        this.reviewerName = reviewerName;
        this.reviewerAvatar = reviewerAvatar;
        this.reviewText = reviewText;
    }

    public int getStars() {
        return stars;
    }

    public String getDate() {
        return date;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewerAvatar() {
        return reviewerAvatar;
    }

    public String getReviewText() {
        return reviewText;
    }
}
