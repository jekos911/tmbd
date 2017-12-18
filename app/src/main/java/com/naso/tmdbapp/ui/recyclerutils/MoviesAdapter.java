package com.naso.tmdbapp.ui.recyclerutils;

import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.naso.tmdbapp.BuildConfig;
import com.naso.tmdbapp.MainActivity;
import com.naso.tmdbapp.R;
import com.naso.tmdbapp.models.Movie;
import com.naso.tmdbapp.models.MoviesLaboratory;

import java.util.List;



public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder>{
    private List<Movie> movies;
    private final FilmClickListner mListner;
    private int code;

    //code == 0 movies
    //code == 1 popular
    //code == 2 top rated
    //code == 3 now playing


    public MoviesAdapter(FilmClickListner listner) {
        movies = MoviesLaboratory.getMovies();
        mListner = listner;
        int code = 0;
    }

    public MoviesAdapter(FilmClickListner listner, int code) {
        mListner = listner;
        this.code = code;
        switch (code)
        {
            case 1: movies = MoviesLaboratory.getPopular();
            break;
            case 2: movies = MoviesLaboratory.getTopRated();
            break;
            case 3: movies = MoviesLaboratory.getNowPlaying();
            break;
            default:  movies = MoviesLaboratory.getMovies();
                break;
        }

    }

    @Override
    public void onBindViewHolder(final MoviesViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        holder.movie = movie;
        if (code == 0)
        {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.imageMovie.getLayoutParams();
            Display display = ((MainActivity)holder.getImageMovie().getContext()).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            params.width = width/2-10;
            params.height = (int)(params.width*1.95f);
            holder.imageMovie.setLayoutParams(params);
        }
        Glide.with(holder.imageMovie.getContext()).load(BuildConfig.API_URL_IMAGE+movie.getPosterUrl()).into(holder.imageMovie);
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
