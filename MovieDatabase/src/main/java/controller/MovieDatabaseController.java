package controller;

import dao.MovieDatabaseDao;
import dao.MovieDatabaseDaoException;
import dto.Movie;
import java.util.List;
import ui.MovieDatabaseView;

/**
 *
 * @author ajplarson
 */
public class MovieDatabaseController {

    //BEGIN: Injection only need these two
    MovieDatabaseView view;
    MovieDatabaseDao dao;
    
    public MovieDatabaseController(MovieDatabaseDao dao, MovieDatabaseView view) {
        this.dao = dao;
        this.view = view;
    }
    //END: Injection

    //BEGIN: Functionality
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        startsWithSearch();
                        break;
                    case 2:
                        createMovie();
                        break;
                    case 3:
                        removeMovie();
                        break;
                    case 4:
                        editMovie();
                        break;
                    case 5:
                        viewAll();
                        break;
                    case 6:
                        viewMovie();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                
            }
            exitMessage();
        } catch (MovieDatabaseDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createMovie() throws MovieDatabaseDaoException {
        view.displayCreateMovieBanner();
        Movie newMovie = view.getNewMovieInfo();
        dao.addMovie(newMovie);
        view.displayMovieID(newMovie);
        view.displayCreateSuccessBanner();
    }
    
    private void viewAll() throws MovieDatabaseDaoException {
        view.displayDisplayAllBanner();
        List<Movie> movieList = dao.getAllMovies();
        view.displayMovieList(movieList);
    }
    
    private void viewMovie() throws MovieDatabaseDaoException {
        view.displayDisplayMovieBanner();
        int movieIndex = view.getMovieIdChoice(0, 10);
        Movie movie = dao.getMovie(movieIndex);
        view.displayMovie(movie);
    }
    
    private void removeMovie() throws MovieDatabaseDaoException {
        view.displayRemoveMovieBanner();
        dao.removeMovie(view.getMovieIdChoice(0, 10));
        view.displayRemoveSuccessBanner();
    }

    //explanation for this method since it is a little more abstract
    private void editMovie() throws MovieDatabaseDaoException {
        view.displayEditMovieBanner();
        int movieIndex = view.getMovieIdChoice(0, 10); //get which movie we want to edit
        Movie editedMovie = view.getEditMovieInfo(dao.getMovie(movieIndex)); //get new info to edit
        dao.editMovie(movieIndex, editedMovie); //sets the old movie's info to the new movie
        view.displayEditMovieSuccessBanner();
    }
    
    private void startsWithSearch() throws MovieDatabaseDaoException {
        view.displaySearchMovieBanner();
        String input = view.getSearchInfo();
        List<Movie> searchList = dao.startsWithSearch(input);
        view.displaySearchList(searchList);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    //END: Functionality
}
