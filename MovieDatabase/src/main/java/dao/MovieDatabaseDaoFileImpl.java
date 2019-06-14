/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class MovieDatabaseDaoFileImpl implements MovieDatabaseDao {

    private ArrayList<Movie> movies = new ArrayList<>();

    @Override
    public Movie addMovie(Movie movie) {
        movies.add(movie);
        movie.setMovieIndex(movies.indexOf(movie));
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public Movie getMovie(int movieIndex) {
        return movies.get(movieIndex);
    }

    @Override
    public Movie removeMovie(int movieIndex) {
        Movie removedMovie = movies.remove(movieIndex);
        return removedMovie;
    }
    
    @Override
    public List<Movie> startsWithSearch(String input) {
        ArrayList<Movie> newList = new ArrayList<>();
        for(Movie currentMovie: movies) {
            if((currentMovie.getTitle().toLowerCase()).startsWith(input.toLowerCase())) {
                newList.add(currentMovie);
            }
        }
        return newList;
    }
}
