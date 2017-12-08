package com.naso.tmdbapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.naso.tmdbapp.BuildConfig;
import com.naso.tmdbapp.R;
import com.naso.tmdbapp.api.TMDbInternetConnection;
import com.naso.tmdbapp.models.GenresList;
import com.naso.tmdbapp.models.Movie;
import com.naso.tmdbapp.models.MoviesLaboratory;
import com.naso.tmdbapp.ui.recyclerutils.GenresAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by жекос on 02.12.2017.
 */

public class GenresFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.genres_fragment,container,false);
        recyclerView = view.findViewById(R.id.genres_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        TMDbInternetConnection.getInterfaceForApi().makeGetRequest().getGenres(BuildConfig.API_ACCESS_TOKEN,"ru").enqueue(new Callback<GenresList>() {
            @Override
            public void onResponse(Call<GenresList> call, Response<GenresList> response) {
                MoviesLaboratory.addGenres(response.body());
                recyclerView.setAdapter(new GenresAdapter());
            }

            @Override
            public void onFailure(Call<GenresList> call, Throwable t) {
                Toast.makeText(getActivity(),getResources().getString(R.string.internet_warning), Toast.LENGTH_LONG).show();
            }
        });
        setExitTransition(new Fade());
        setEnterTransition(new Fade());

        getActivity().setTitle("Жанры");

        return view;
    }
}
