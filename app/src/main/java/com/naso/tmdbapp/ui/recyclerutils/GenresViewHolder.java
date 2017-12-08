package com.naso.tmdbapp.ui.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.naso.tmdbapp.BuildConfig;
import com.naso.tmdbapp.MainActivity;
import com.naso.tmdbapp.R;
import com.naso.tmdbapp.api.TMDbInternetConnection;
import com.naso.tmdbapp.models.FilmsList;
import com.naso.tmdbapp.models.Genre;
import com.naso.tmdbapp.models.MoviesLaboratory;
import com.naso.tmdbapp.ui.FilmListFragment;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class GenresViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    protected ImageView imageGenre;
    protected TextView titleGenre;
    protected Genre genre;

    public GenresViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imageGenre = itemView.findViewById(R.id.genre_image);
        titleGenre = itemView.findViewById(R.id.genre_title);
    }


    @Override
    public void onClick(View view) {
        TMDbInternetConnection.getInterfaceForApi().makeGetRequest().getMovies(genre.getIdGenre(), BuildConfig.API_ACCESS_TOKEN,"ru").enqueue(new Callback<FilmsList>() {
            @Override
            public void onResponse(Call<FilmsList> call, Response<FilmsList> response) {
                FilmListFragment fragment = new FilmListFragment();
                fragment.setEnterTransition(new Fade());
                MoviesLaboratory.setFilmsList(response.body());
                MainActivity.getFragmentManagerFromActivity()
                        .beginTransaction()
                        .replace(R.id.container,new FilmListFragment())
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onFailure(Call<FilmsList> call, Throwable t) {
                Toast.makeText(imageGenre.getContext(),imageGenre.getContext().getResources().getString(R.string.internet_warning),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void updateImg()
    {
        getDrawResource(imageGenre,genre);
    }

    private void getDrawResource(ImageView view,Genre genre) {
        int id = genre.getIdGenre();
        switch (id) {
            case (28):
                Glide.with(view.getContext()).load(new String("http://www.ural.org/wp-content/uploads/2016/10/zhanr-kino-boevik-www-ural-org.jpg")).into(view);
                break;
            case (12):
                Glide.with(view.getContext()).load(new String("http://c1.emosurf.com/0001170ZDyvJ/clip_image002_thumb3.jpg")).into(view);
                break;
            case (16):
                Glide.with(view.getContext()).load(new String("https://i.ytimg.com/vi/8sXcOc4R8-o/maxresdefault.jpg")).into(view);
                break;
            case (35):
                Glide.with(view.getContext()).load(new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTveFr_wSzWBA7FA6dtRbzuMUBLGki6Yl2Rk1YQgsY3CIWhXT1M")).into(view);
                break;
            case (80):
                Glide.with(view.getContext()).load(new String("http://perebezhchik.ru/u/news/thumb_3d1e0fc9d5184f3c72aea2d45cfa8246.jpg")).into(view);
                break;
            case (99):
                Glide.with(view.getContext()).load(new String("http://ufology-news.com/wp-content/uploads/2014/06/Cosmos_A_Spacetime_Odyssey_2014.jpg")).into(view);
                break;
            case (18):
                Glide.with(view.getContext()).load(new String("http://novinki-kino-afisha.ru/images/zhanr-drama-1.jpg")).into(view);
                break;
            case (10751):
                Glide.with(view.getContext()).load(new String("http://www.tourstars.ru/ckfiles/images/articles/150-200/192.jpg")).into(view);
                break;
            case (14):
                Glide.with(view.getContext()).load(new String("https://cs4.pikabu.ru/post_img/big/2016/06/07/11/146532818419689320.jpg")).into(view);
                break;
            case (36):
                Glide.with(view.getContext()).load(new String("https://shkolazhizni.ru/img/content/i116/116526_or.jpg")).into(view);
                break;
            case (27):
                Glide.with(view.getContext()).load(new String("http://top-reyting.ru/images/glavnie/kino/luchie-ujasi-2017.jpg")).into(view);
                break;
            case (10402):
                Glide.with(view.getContext()).load(new String("http://real-parents.com/wp-content/uploads/2016/04/Butterfly-Music.jpg")).into(view);
                break;
            case (9648):
                Glide.with(view.getContext()).load(new String("http://detective-nikolaev.com/images/1.jpg")).into(view);
                break;
            case (10749):
                Glide.with(view.getContext()).load(new String("http://fb.ru/misc/i/gallery/22293/1860838.jpg")).into(view);
                break;
            case (878):
                Glide.with(view.getContext()).load(new String("https://habrastorage.org/getpro/geektimes/post_images/f82/cd6/bf7/f82cd6bf7624c64c0e4bada8015e0f96.jpg")).into(view);
                break;
            case (10770):
                Glide.with(view.getContext()).load(new String("http://c1.emosurf.com/0001170ZDyvJ/clip_image002_thumb3.jpg")).into(view);
                break;
            case (53):
                Glide.with(view.getContext()).load(new String("http://top-reyting.ru/images/glavnie/kino/reyting-trillerov.jpg")).into(view);
                break;
            case (10752):
                Glide.with(view.getContext()).load(new String("http://batona.net/uploads/posts/2011-06/1309324125_01.jpg")).into(view);
                break;
            case (37):
                Glide.with(view.getContext()).load(new String("https://i.ytimg.com/vi/A_rwtgRA3cI/maxresdefault.jpg")).into(view);
                break;
        }
    }
}
