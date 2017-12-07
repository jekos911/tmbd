package com.naso.tmdbapp.ui.recyclerutils;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.naso.tmdbapp.BuildConfig;
import com.naso.tmdbapp.R;
import com.naso.tmdbapp.models.Movie;
import com.naso.tmdbapp.models.MoviesLaboratory;

import java.util.List;

/**
 * Created by жекос on 02.12.2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder>{
    private List<Movie> movies;
    private final FilmClickListner mListner;

    public MoviesAdapter(FilmClickListner listner) {
        movies = MoviesLaboratory.getMovies();
        mListner = listner;
    }

    @Override
    public void onBindViewHolder(final MoviesViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        holder.movie = movie;
        Glide.with(holder.imageMovie.getContext()).load(BuildConfig.API_URL_IMAGE+movie.getPosterUrl()).into(holder.imageMovie);
        ViewCompat.setTransitionName(holder.imageMovie, String.valueOf(position) + "_image");
        holder.imageMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListner.onFilmClicked(holder,movie.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item,parent,false);
        MoviesViewHolder vh = new MoviesViewHolder(v);
        return vh;
    }

}
