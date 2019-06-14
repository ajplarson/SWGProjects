/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.moviedatabase;

import controller.MovieDatabaseController;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) {
        MovieDatabaseController movieController = new MovieDatabaseController();
        movieController.run();
    }
}
