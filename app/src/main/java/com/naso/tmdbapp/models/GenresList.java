package com.naso.tmdbapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class GenresList {
    @SerializedName("genres")
    private List<Genre> genres = new ArrayList<Genre>();

    public List<Genre> getGenres() {
        return genres;
    }
}
