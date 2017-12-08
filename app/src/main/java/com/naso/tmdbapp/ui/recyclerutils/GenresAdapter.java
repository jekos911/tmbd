package com.naso.tmdbapp.ui.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naso.tmdbapp.R;
import com.naso.tmdbapp.models.Genre;
import com.naso.tmdbapp.models.MoviesLaboratory;

import java.util.List;



public class GenresAdapter extends RecyclerView.Adapter<GenresViewHolder> {

    private List<Genre> genres;

    public GenresAdapter() {
        genres = MoviesLaboratory.getGenres();
    }

    @Override
    public void onBindViewHolder(GenresViewHolder holder, int position) {
        Genre genre = genres.get(position);
        holder.titleGenre.setText(genre.getNameGenre());
        holder.genre = genre;
        holder.updateImg();
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    @Override
    public GenresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_item,parent,false);
        GenresViewHolder vh = new GenresViewHolder(v);
        return  vh;
    }
}
