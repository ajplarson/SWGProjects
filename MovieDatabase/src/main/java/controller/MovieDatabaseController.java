/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MovieDatabaseDao;
import dao.MovieDatabaseDaoFileImpl;
import dto.Movie;
import java.util.List;
import ui.MovieDatabaseView;
import ui.UserIO;
import ui.UserIOImpl;

/**
 *
 * @author ajplarson
 */
public class MovieDatabaseController {

    private UserIO io = new UserIOImpl();
    MovieDatabaseView view = new MovieDatabaseView();
    MovieDatabaseDao dao = new MovieDatabaseDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    io.print("Search Movie");
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
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createMovie() {
        view.displayCreateMovieBanner();
        Movie newMovie = view.getNewMovieInfo();
        dao.addMovie(newMovie);
        view.displayMovieID(newMovie);
        view.displayCreateSuccessBanner();
    }

    private void viewAll() {
        view.displayDisplayAllBanner();
        List<Movie> movieList = dao.getAllMovies();
        view.displayMovieList(movieList);
    }

    private void viewMovie() {
        view.displayDisplayMovieBanner();
        int movieIndex = view.getMovieIdChoice();
        Movie movie = dao.getMovie(movieIndex);
        view.displayMovie(movie);
    }

    private void removeMovie() {
        view.displayRemoveMovieBanner();
        int movieID = view.getMovieIdChoice();
        dao.removeMovie(movieID);
        view.displayRemoveSuccessBanner();
    }

    private void editMovie() {
        view.displayEditMovieBanner();
        int movieID = view.getMovieIdChoice();
        Movie movie = dao.getMovie(movieID);
        view.getEditMovieInfo(movie);
        view.displayEditMovieSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
