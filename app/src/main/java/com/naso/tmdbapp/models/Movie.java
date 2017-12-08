package com.naso.tmdbapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;



public class Movie {

    @SerializedName("id")
    private int id;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("backdrop_path")
    private String backPictureUrl;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterUrl;

    @SerializedName("release_date")
    private Date releaseDate;

    @SerializedName("vote_average")
    private float voteAverage;

    public boolean isAdult() {
        return adult;
    }

    public String getBackPictureUrl() {
        return backPictureUrl;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public int getId() {
        return id;
    }
}
