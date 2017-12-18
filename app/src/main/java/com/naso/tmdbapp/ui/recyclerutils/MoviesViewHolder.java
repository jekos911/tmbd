package com.naso.tmdbapp.ui.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.naso.tmdbapp.R;
import com.naso.tmdbapp.models.Movie;




public class MoviesViewHolder extends RecyclerView.ViewHolder {

    protected ImageView imageMovie;
    protected Movie movie;



    public MoviesViewHolder(View itemView) {
        super(itemView);
        imageMovie = itemView.findViewById(R.id.movie_image);

    }

    public Movie getMovie() {
        return movie;
    }

    public ImageView getImageMovie() {
        return imageMovie;
    }


}
