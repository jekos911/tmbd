package com.naso.tmdbapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naso.tmdbapp.BuildConfig;
import com.naso.tmdbapp.R;
import com.naso.tmdbapp.models.Movie;
import com.naso.tmdbapp.models.MoviesLaboratory;

/**
 * Created by жекос on 02.12.2017.
 */

public class MovieDetailFragment extends Fragment {
    private final static String ARG_KEY = "MOVIE_ID";
    private Movie movie;

    public static MovieDetailFragment newInstance(int id) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_KEY, id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        movie = MoviesLaboratory.getMovie(getArguments().getInt(ARG_KEY));
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.film_detail_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView origTitle = view.findViewById(R.id.title_orig);
        origTitle.setText(movie.getOriginalTitle());
        TextView localTitle = view.findViewById(R.id.title_local);
        localTitle.setText(movie.getTitle());
        ImageView poster = view.findViewById(R.id.poster);
        Glide.with(view.getContext()).load(BuildConfig.API_URL_IMAGE+movie.getPosterUrl()).into(poster);
        TextView description = view.findViewById(R.id.description);
        description.setText(movie.getOverview());
    }
}
