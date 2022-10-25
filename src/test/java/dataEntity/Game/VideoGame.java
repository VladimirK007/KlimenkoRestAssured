package dataEntity.Game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoGame {

    public VideoGame(){}

    @JsonProperty("reviewScore")
    private int reviewScore;

    @JsonProperty("releaseDate")
    private String releaseDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("id")
    private int id;

    @JsonProperty("category")
    private String category;

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return " Game id: " + id + "\n" +
                " Game name: " + name + "\n" +
                " In category: " + category + "\n" +
                " was released: " + releaseDate;
    }

    public VideoGame(String name, int id, String category, String releaseDate) {
        this.category = category;
        this.name = name;
        this.releaseDate = releaseDate;
        this.id = id;
    }

}