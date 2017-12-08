package com.naso.tmdbapp.models;

import com.google.gson.annotations.SerializedName;


public class Genre {
    @SerializedName("id")
    private int idGenre;

    @SerializedName("name")
    private String nameGenre;

    public int getIdGenre() {
        return idGenre;
    }

    public String getNameGenre() {
        return nameGenre;
    }
}
