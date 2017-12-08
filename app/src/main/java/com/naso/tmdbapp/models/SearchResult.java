package com.naso.tmdbapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SearchResult {

    @SerializedName("results")
    private List<Movie> moviesList;

    public List<Movie> getMoviesList() {
        return moviesList;
    }
}
