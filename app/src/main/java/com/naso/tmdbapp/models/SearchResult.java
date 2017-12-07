package com.naso.tmdbapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by жекос on 05.12.2017.
 */

public class SearchResult {

    @SerializedName("results")
    private List<Movie> moviesList;

    public List<Movie> getMoviesList() {
        return moviesList;
    }
}
