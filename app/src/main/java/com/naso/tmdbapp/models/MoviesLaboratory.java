package com.naso.tmdbapp.models;

import java.util.ArrayList;
import java.util.List;



public class MoviesLaboratory {
    private static GenresList genresList = new GenresList();
    private static List<Movie> filmList = new ArrayList<Movie>();

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
        return null;
    }
}
