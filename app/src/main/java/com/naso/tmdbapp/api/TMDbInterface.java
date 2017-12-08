package com.naso.tmdbapp.api;

import com.naso.tmdbapp.models.FilmsList;
import com.naso.tmdbapp.models.GenresList;
import com.naso.tmdbapp.models.Movie;
import com.naso.tmdbapp.models.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface TMDbInterface {
    @GET("/3/genre/movie/list")
    Call<GenresList> getGenres(@Query("api_key") String key, @Query("language") String lang);

    @GET("/3/genre/{genre_id}/movies")
    Call<FilmsList> getMovies (@Path("genre_id") int genge_id, @Query("api_key") String key, @Query("language") String lang);

    @GET("/3/movie/{movie_id}")
    Call<Movie> getMovie (@Path("movie_id") int movie_id, @Query("api_key") String key, @Query("language") String lang);

    @GET("/3/search/movie")
    Call<SearchResult> getSearchResult (@Query("api_key") String key, @Query("language") String lang, @Query("query") String query);
}
