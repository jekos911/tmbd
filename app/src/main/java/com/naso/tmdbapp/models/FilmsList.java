package com.naso.tmdbapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class FilmsList {
    @SerializedName("id")
    private int genreId;

    @SerializedName("results")
    private List<Movie> moviesList;

    public int getGenreId() {
        return genreId;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }
}
