package com.naso.tmdbapp.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.naso.tmdbapp.BuildConfig;
import com.naso.tmdbapp.R;
import com.naso.tmdbapp.api.TMDbInternetConnection;
import com.naso.tmdbapp.models.GenresList;
import com.naso.tmdbapp.models.MoviesLaboratory;
import com.naso.tmdbapp.models.SearchResult;
import com.naso.tmdbapp.ui.recyclerutils.FilmClickListner;
import com.naso.tmdbapp.ui.recyclerutils.GenresAdapter;
import com.naso.tmdbapp.ui.recyclerutils.MoviesAdapter;
import com.naso.tmdbapp.ui.recyclerutils.MoviesViewHolder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by жекос on 02.12.2017.
 */

public class FilmListFragment extends Fragment implements FilmClickListner{
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.genres_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.genres_list);
        updateUI();
    }

    @Override
    public void onFilmClicked(MoviesViewHolder holder, int id) {
        MovieDetailFragment fragment= MovieDetailFragment.newInstance(holder.getMovie().getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.setSharedElementEnterTransition(new DetailsTransition());
            fragment.setEnterTransition(new Fade());
            setExitTransition(new Fade());
            fragment.setSharedElementReturnTransition(new DetailsTransition());
        }

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addSharedElement(holder.getImageMovie(),"movieImage")
                .replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_search,menu);

        MenuItem searchItem = menu.findItem(R.id.menu_item_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                TMDbInternetConnection.getInterfaceForApi().makeGetRequest().getSearchResult(BuildConfig.API_ACCESS_TOKEN,"ru",s).enqueue(new Callback<SearchResult>() {
                    @Override
                    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                        MoviesLaboratory.setFilmList(response.body().getMoviesList());
                        updateUI();
                    }

                    @Override
                    public void onFailure(Call<SearchResult> call, Throwable t) {
                        Toast.makeText(getActivity(),getResources().getString(R.string.internet_warning), Toast.LENGTH_LONG).show();
                    }
                });
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
    }

    private void updateUI() {
        recyclerView.setAdapter(new MoviesAdapter(this));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}
