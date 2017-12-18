package com.naso.tmdbapp.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.naso.tmdbapp.BuildConfig;
import com.naso.tmdbapp.R;
import com.naso.tmdbapp.api.TMDbInternetConnection;
import com.naso.tmdbapp.models.MoviesLaboratory;
import com.naso.tmdbapp.models.SearchResult;
import com.naso.tmdbapp.ui.recyclerutils.FilmClickListner;
import com.naso.tmdbapp.ui.recyclerutils.MoviesAdapter;
import com.naso.tmdbapp.ui.recyclerutils.MoviesViewHolder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by жекос on 16.12.2017.
 */

public class StartFragment extends Fragment implements FilmClickListner{

    RecyclerView popularRecycler = null;
    RecyclerView topRatedRecycler = null;
    RecyclerView nowPlayingRecycler = null;
    StartFragment sfa = null;
    Button but = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("Це Киноафiша");
        View view = inflater.inflate(R.layout.start_fragment_layout,container,false);
        sfa = this;
        popularRecycler = view.findViewById(R.id.recycler_popular);
        topRatedRecycler = view.findViewById(R.id.recycler_top_rated);
        nowPlayingRecycler = view.findViewById(R.id.recycler_now_playing);
        but = view.findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new GenresFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        TMDbInternetConnection.getInterfaceForApi().makeGetRequest().getNowPlaying(BuildConfig.API_ACCESS_TOKEN,"ru").enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                MoviesLaboratory.setNowPlaying(response.body().getMoviesList());
                LinearLayoutManager lManager = new LinearLayoutManager(getContext());
                lManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                nowPlayingRecycler.setLayoutManager(lManager);
                nowPlayingRecycler.setAdapter(new MoviesAdapter(sfa,3));

            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Toast.makeText(getActivity(),getResources().getString(R.string.internet_warning), Toast.LENGTH_LONG).show();
            }
        });



        TMDbInternetConnection.getInterfaceForApi().makeGetRequest().getPopular(BuildConfig.API_ACCESS_TOKEN,"ru").enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                MoviesLaboratory.setPopular(response.body().getMoviesList());
                LinearLayoutManager lManager = new LinearLayoutManager(getContext());
                lManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                popularRecycler.setLayoutManager(lManager);
                popularRecycler.setAdapter(new MoviesAdapter(sfa,1));
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Toast.makeText(getActivity(),getResources().getString(R.string.internet_warning), Toast.LENGTH_LONG).show();
            }
        });


        TMDbInternetConnection.getInterfaceForApi().makeGetRequest().getTopRated(BuildConfig.API_ACCESS_TOKEN,"ru").enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                MoviesLaboratory.setTopRated(response.body().getMoviesList());
                MoviesLaboratory.setPopular(response.body().getMoviesList());
                LinearLayoutManager lManager = new LinearLayoutManager(getContext());
                lManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                topRatedRecycler.setLayoutManager(lManager);
                topRatedRecycler.setAdapter(new MoviesAdapter(sfa,1));
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Toast.makeText(getActivity(),getResources().getString(R.string.internet_warning), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onFilmClicked(MoviesViewHolder holder, int id) {
        MovieDetailFragment fragment= MovieDetailFragment.newInstance(holder.getMovie().getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.setEnterTransition(new Fade());
            setExitTransition(new Fade());;
        }

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit();
    }
}
