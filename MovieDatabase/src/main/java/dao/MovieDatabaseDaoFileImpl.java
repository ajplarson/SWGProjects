package dao;

import dto.Movie;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class MovieDatabaseDaoFileImpl implements MovieDatabaseDao {

    public static final String DATABASE_FILE = "database.txt";
    public static final String DELIMITER = "::";

    private ArrayList<Movie> movies = new ArrayList<>();

    //BEGIN: File reader then writer
    private Movie unmarshallMovie(String movieAsText) {
        //we are expecting a line read in from our file like the following
        //MovieTitle::MM/DD/YY::DirectorName::mpaaRating::Studio::UserRating
        String[] movieTokens = movieAsText.split(DELIMITER);
        Movie unmarshalledMovie = new Movie();
        //specify the indices
        //0 -> Title
        unmarshalledMovie.setTitle(movieTokens[0]);
        //1 -> Date
        unmarshalledMovie.setReleaseDate(movieTokens[1]);
        //2 -> Director
        unmarshalledMovie.setDirectorName(movieTokens[2]);
        //3 -> mpaaRating
        unmarshalledMovie.setMpaaRating(movieTokens[3]);
        //4 -> Studio
        unmarshalledMovie.setStudio(movieTokens[4]);
        //5 -> UserRating
        unmarshalledMovie.setUserRating(movieTokens[5]);

        return unmarshalledMovie;

    }

    private void loadDatabase() throws MovieDatabaseDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DATABASE_FILE)));
        } catch (FileNotFoundException e) {
            throw new MovieDatabaseDaoException("Could not load file into database", e);
        }

        String currentLine;
        Movie currentMovie;

        //loops through while still lines
        //sets current line to line being read then unmarshalls that line
        //currentMovie then becomes that unmarshalled line
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentMovie = unmarshallMovie(currentLine);
            movies.add(currentMovie);
            currentMovie.setMovieIndex(movies.indexOf(currentMovie));
        }
        scanner.close();
    }

    private String marshallMovie(Movie aMovie) {
        //we want to write a movie into a line of text matching the below format
        //MovieTitle::MM/DD/YY::DirectorName::mpaaRating::Studio::UserRating
        String movieAsText = aMovie.getTitle() + DELIMITER;
        movieAsText += aMovie.getReleaseDate() + DELIMITER;
        movieAsText += aMovie.getDirectorName() + DELIMITER;
        movieAsText += aMovie.getMpaaRating() + DELIMITER;
        movieAsText += aMovie.getStudio() + DELIMITER;
        movieAsText += aMovie.getUserRating();

        return movieAsText;
    }

    private void writeDatabase() throws MovieDatabaseDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DATABASE_FILE));
        } catch (IOException e) {
            throw new MovieDatabaseDaoException("Could not save database", e);
        }
        String movieAsText;
        List<Movie> movieList = this.getAllMovies();
        for (Movie currentMovie : movieList) {
            movieAsText = marshallMovie(currentMovie);
            out.println(movieAsText);
            out.flush();
        }
        out.close();

    }

    //END: File reader then writer
    //BEGIN: Application methods
    //From Angelina on Slack: Only need to load database if list is empty
    @Override
    public Movie addMovie(Movie movie) throws MovieDatabaseDaoException {
        if (movies.isEmpty()) {
            loadDatabase();
        }
        movies.add(movie);
        movie.setMovieIndex(movies.indexOf(movie));
        writeDatabase();
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() throws MovieDatabaseDaoException {
        if (movies.isEmpty()) {
            loadDatabase();
        }
        return movies;
    }

    @Override
    public Movie getMovie(int movieIndex) throws MovieDatabaseDaoException {
        if (movies.isEmpty()) {
            loadDatabase();
        }
        return movies.get(movieIndex);
    }

    @Override
    public Movie removeMovie(int movieIndex) throws MovieDatabaseDaoException {
        if (movies.isEmpty()) {
            loadDatabase();
        }
        Movie removedMovie = movies.remove(movieIndex);
        writeDatabase();
        return removedMovie;
    }

    @Override
    public Movie editMovie(int movieIndex, Movie editedMovie) throws MovieDatabaseDaoException {
        if (movies.isEmpty()) {
            loadDatabase();
        }
        //set all info in the old movie to the new entered info
        Movie movie = movies.get(movieIndex);
        movie.setTitle(editedMovie.getTitle());
        movie.setDirectorName(editedMovie.getDirectorName());
        movie.setMpaaRating(editedMovie.getMpaaRating());
        movie.setReleaseDate(editedMovie.getReleaseDate());
        movie.setStudio(editedMovie.getStudio());
        movie.setUserRating(editedMovie.getUserRating());
        writeDatabase();
        return movie;
    }

    @Override
    public List<Movie> startsWithSearch(String input) throws MovieDatabaseDaoException {
        if (movies.isEmpty()) {
            loadDatabase();
        }
        ArrayList<Movie> newList = new ArrayList<>();
        for (Movie currentMovie : movies) {
            if ((currentMovie.getTitle().toLowerCase()).startsWith(input.toLowerCase())) {
                newList.add(currentMovie);
            }
        }
        if (newList.size() == 0) {
            return null; //returns null to communicate no entry found
        } else {
            return newList;
        }
    }
    //END: Application methods
}
