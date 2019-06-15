package ui;

import dto.Movie;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class MovieDatabaseView {

    private UserIO io;

    public MovieDatabaseView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu for AJPDB");
        io.print("1. Search for a Movie");
        io.print("2. Add a movie to the database");
        io.print("3. Remove a movie from the database");
        io.print("4. Edit a movie in the database");
        io.print("5. View all movies in the data base");
        io.print("6. View information about a specific movie");
        io.print("7. Exit");
        return io.readInt("Please select from the above choices.", 1, 7);
    }

    //BEGIN: add movie functionality
    public Movie getNewMovieInfo() {
        //get all required info
        String title = io.readString("Please enter the movie title");
        String name = io.readString("Please enter the director's first and last name");
        String releaseDate = io.readString("Please enter the movie's Release Date [MM/DD/YY]");
        String mpaaRating = io.readString("Please enter the movie's MPAA Rating");
        String studio = io.readString("Please enter the movie's studio");
        String rating = io.readString("Please enter the movie's 5-star rating");
        //set all required info
        Movie currentMovie = new Movie();
        currentMovie.setTitle(title);
        currentMovie.setDirectorName(name);
        currentMovie.setReleaseDate(releaseDate);
        currentMovie.setMpaaRating(mpaaRating);
        currentMovie.setStudio(studio);
        currentMovie.setUserRating(rating);

        return currentMovie;
    }

    public void displayCreateMovieBanner() {
        io.print("===== Add a Movie =====");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Movie Successfully added. Please hit enter to continue");
    }

    public void displayMovieID(Movie movie) {
        io.print("This movie's ID number is: 000" + movie.getMovieIndex());
    }
    //END: add movie 

    //BEGIN: viewAll movies functionality
    public void displayMovieList(List<Movie> movieList) {
        for (Movie currentMovie : movieList) {
            io.print((currentMovie.getMovieIndex()) + ": "
                    + (currentMovie.getTitle()) + " - "
                    + currentMovie.getDirectorName());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("===== All movies in AJPDB  =====");
    }
    //END: viewAll movies

    //BEGIN: get a specific movie based off of index
    public void displayDisplayMovieBanner() {
        io.print("===== Find a Movie by ID =====");
    }

    public int getMovieIdChoice() {
        return io.readInt("Please enter the movie's ID number. \n[for 0001 enter 1]");
    }

    public void displayMovie(Movie movie) {
        if (movie != null) {
            io.print("_________________________");
            io.print("ID: " + movie.getMovieIndex());
            io.print("Title: " + movie.getTitle());
            io.print("Director: " + movie.getDirectorName());
            io.print("User Rating: " + movie.getUserRating() + " out of 5 stars");
            io.print("Release Date: " + movie.getReleaseDate());
            io.print("Studio: " + movie.getStudio());
            io.print("MPAA Rating: " + movie.getMpaaRating());
            io.print("_________________________");
        } else {
            io.print("That movie does not exist in AJPDB");
        }
        io.readString("Please hit enter to continue.");

    }
    //END: specific movie choice

    //BEGIN: remove student 
    public void displayRemoveMovieBanner() {
        io.print("===== Remove a Movie =====");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Movie succesfully removed. Please hit enter to continue");
    }

    //END: remove student
    public void displayExitBanner() {
        io.print("____________________");
        io.print("Good Bye");
        io.print("____________________");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    //BEGIN: Edit
    public void displayEditMovieBanner() {
        io.print("===== Edit a Movie =====");
    }

    public Movie getEditMovieInfo() {
        Movie editedMovie = new Movie();
        //get all required info
        String title = io.readString("Please enter the new desired title");
        String name = io.readString("Please enter the new desired director's first and last name");
        String releaseDate = io.readString("Please enter the new desired movie's Release Date [MM/DD/YY]");
        String mpaaRating = io.readString("Please enter the new desired movie's MPAA Rating");
        String studio = io.readString("Please enter the new desired movie's studio");
        String rating = io.readString("Please enter the new desired movie's 5-star rating");
        //set all required info
        editedMovie.setTitle(title);
        editedMovie.setDirectorName(name);
        editedMovie.setReleaseDate(releaseDate);
        editedMovie.setMpaaRating(mpaaRating);
        editedMovie.setStudio(studio);
        editedMovie.setUserRating(rating);

        return editedMovie;
    }

    public void displayEditMovieSuccessBanner() {
        io.print("Movie was successfully edited");
    }
    //END: Edit

    //BEGIN: Starts With Search
    public void displaySearchMovieBanner() {
        io.print("===== Movie Search =====");
    }

    public String getSearchInfo() {
        return io.readString("Please enter a series of characters that the movie starts with\nFor example, type sta for Star Wars");
    }

    public void displaySearchList(List<Movie> searchList) {
        if (searchList != null) {
            for (Movie currentMovie : searchList) {
                io.print((currentMovie.getMovieIndex()) + ": "
                        + (currentMovie.getTitle()) + " - "
                        + currentMovie.getDirectorName());
            }
            io.readString("Please hit enter to continue.");
        } else {
            io.print("No movies match that series of characters");
        }
    }

    //END: Starts With Search
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
