package com.naso.tmdbapp.models;

import java.util.ArrayList;
import java.util.List;



public class MoviesLaboratory {
    private static GenresList genresList = new GenresList();
    private static List<Movie> filmList = new ArrayList<Movie>();

    private static List<Movie> popular = new ArrayList<Movie>();
    private static List<Movie> nowPlaying = new ArrayList<Movie>();
    private static List<Movie> topRated = new ArrayList<Movie>();

    public static void addGenres(GenresList gList) {
        genresList = gList;
    }
    public static void setFilmsList(FilmsList films) { filmList  = films.getMoviesList(); }
    public static void setFilmList(List<Movie> films) { filmList = films; }

    public static List<Genre> getGenres() {
        return genresList.getGenres();
    }

    public static List<Movie> getMovies()
    {
        return filmList;
    }

    public static Movie getMovie(int id) {
        for (Movie movie: filmList) {
            if (movie.getId()==id)
                return movie;
        }
        for (Movie movie: popular) {
            if (movie.getId()==id)
                return movie;
        }
        for (Movie movie: nowPlaying) {
            if (movie.getId()==id)
                return movie;
        }
        for (Movie movie: topRated) {
            if (movie.getId()==id)
                return movie;
        }
        return null;
    }

    public static List<Movie> getPopular() {
        return popular;
    }

    public static void setPopular(List<Movie> popular) {
        MoviesLaboratory.popular = popular;
    }

    public static List<Movie> getNowPlaying() {
        return nowPlaying;
    }

    public static void setNowPlaying(List<Movie> nowPlaying) {
        MoviesLaboratory.nowPlaying = nowPlaying;
    }

    public static List<Movie> getTopRated() {
        return topRated;
    }

    public static void setTopRated(List<Movie> topRated) {
        MoviesLaboratory.topRated = topRated;
    }
}
