package dao;

import dto.Movie;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public interface MovieDatabaseDao {

    /**
     * Adds the given movie to the database and associates it with the given
     * movie id. If there is already a movie associated with the given movie id
     * it will return that movie object, otherwise it will return null.
     *
     * @param Movie movie to be added to the roster
     * @return the movie object previously associated with the given movie id if
     * it exists, null otherwise
     */
    Movie addMovie(Movie movie) throws MovieDatabaseDaoException;

    /**
     * Returns a String array containing the movie ids of all movies in the
     * database.
     *
     * @return String array containing the ids of all the movies in the database
     */
    List<Movie> getAllMovies() throws MovieDatabaseDaoException;

    /**
     * Returns the movie object associated with the given movie id. Returns null
     * if no such movie exists
     *
     * @param movieIndex index of the movie to retrieve
     * @return the Movie object associated with the given movie id, null if no
     * such movie exists
     */
    Movie getMovie(int movieIndex) throws MovieDatabaseDaoException;

    /**
     * Removes from the database the movie associated with the given id. Returns
     * the movie object that is being removed or null if there is no movie
     * associated with the given id
     *
     * @param movieIndex index of movie to be removed
     * @return Movie object that was removed or null if no movie was associated
     * with the given movie id
     */
    Movie removeMovie(int movieIndex) throws MovieDatabaseDaoException;
    
    
    /**
     * 
     * takes a movie index and edited version of that movie. then sets the movie
     * to the new edited version
     * 
     * @param movieIndex index of movie we will rewrite
     * @param movie movie created from new movie info from the user
     * @return movie after it has been set to the new movie
     * @throws MovieDatabaseDaoException 
     */
    Movie editMovie(int movieIndex, Movie movie) throws MovieDatabaseDaoException;

    /**
     *
     * Returns a list of movies in the database that start with the letters
     * entered by the user in input. returns null if no movies were associated
     * with that input
     *
     * @param input user search input
     * @return list of Movie objects that match the search criterion or null if
     * no movies were found that match the input
     */
    List<Movie> startsWithSearch(String input) throws MovieDatabaseDaoException;
}
