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
        io.print("1. Search for a Movie by title");
        io.print("2. Add a movie to the database");
        io.print("3. Remove a movie from the database");
        io.print("4. Edit a movie in the database by ID");
        io.print("5. View all movies in the database");
        io.print("6. Search for a Movie by ID");
        io.print("7. Exit");
        return io.readInt("Please select from the above choices.", 1, 7);
    }

    //BEGIN: add movie functionality
    public Movie getNewMovieInfo() {
        //get all required info
        String title = io.readString("Please enter the movie title");
        String name = io.readString("Please enter the director's name");
        String releaseDate = io.readString("Please enter the movie's Release Date\nPreferred format as year or [MM/DD/YY]");
        String rating = io.readString("Please enter a movie rating (1-10 stars) or review");
        String studio = io.readString("Please enter the movie's studio");
        String mpaaRating = io.readString("Please enter the movie's MPAA Rating [G, PG, PG-13, R, or NC-17]");

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
        io.print("This movie's ID number is: 00" + movie.getMovieIndex());
    }
    //END: add movie 

    //BEGIN: viewAll movies functionality
    public void displayMovieList(List<Movie> movieList) {
        for (Movie currentMovie : movieList) {
            io.print("00" + currentMovie.getMovieIndex() + ": " + currentMovie.getTitle() + " - "
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

    public int getMovieIdChoice(int min, int max) {
        int index = 0;
        do {
            index = io.readInt("Please enter the movie's ID number. \n[for 0001 enter 1]");
        } while (index <= min || index >= max);
        return index;
    }

    public void displayMovie(Movie movie) {
        if (movie != null) {
            io.print("_________________________");
            io.print("ID: 00" + movie.getMovieIndex()); //the 00 makes it look nicer
            io.print("Title: " + movie.getTitle());
            io.print("Director: " + movie.getDirectorName());
            io.print("Release Date: " + movie.getReleaseDate());
            io.print("User Rating: " + movie.getUserRating());
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
        io.print("________");
        io.print("GOOD BYE");
        io.print("________");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    //BEGIN: Edit
    public void displayEditMovieBanner() {
        io.print("===== Edit a Movie =====");
    }

    public Movie getEditMovieInfo(Movie movie) {
        displayMovie(movie);
        Movie editedMovie = new Movie();
        //get all required info
        String title = io.readString("Please enter the new desired title or press enter to skip changing this item");
        String name = io.readString("Please enter the new desired director's name or press enter to skip changing this item");
        String releaseDate = io.readString("Please enter the new desired movie's Release Date or press enter to skip changing this item");
        String rating = io.readString("Please enter the new desired movie's rating or press enter to skip changing this item");
        String studio = io.readString("Please enter the new desired movie's studio or press enter to skip changing this item");
        String mpaaRating = io.readString("Please enter the new desired movie's MPAA Rating or press enter to skip changing this item");

        //set all required info
        if (!(title.isBlank())) { //if the title is not blank set it otherwise keep the same
            editedMovie.setTitle(title);
        } else {
            editedMovie.setTitle(movie.getTitle());
        }
        //same logic for all other cases
        if (!(name.isBlank())) {
            editedMovie.setDirectorName(name);
        } else {
            editedMovie.setDirectorName(movie.getDirectorName());
        }
        if (!(releaseDate.isBlank())) {
            editedMovie.setReleaseDate(releaseDate);
        } else {
            editedMovie.setReleaseDate(movie.getReleaseDate());
        }
        if (!(mpaaRating.isBlank())) {
            editedMovie.setMpaaRating(mpaaRating);
        } else {
            editedMovie.setMpaaRating(movie.getMpaaRating());
        }
        if (!(studio.isBlank())) {
            editedMovie.setStudio(studio);
        } else {
            editedMovie.setStudio(movie.getStudio());
        }
        if (!(rating.isBlank())) {
            editedMovie.setUserRating(rating);
        } else {
            editedMovie.setUserRating(movie.getUserRating());
        }

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
                io.print("00" + (currentMovie.getMovieIndex()) + ": "
                        + (currentMovie.getTitle()) + " - "
                        + currentMovie.getDirectorName());
            }
        } else {
            io.print("No movies match that series of characters");
        }
        io.readString("Please hit enter to continue."); //either way hit enter to continue
    }

    //END: Starts With Search
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
