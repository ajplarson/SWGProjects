/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ajplarson
 */
public class MovieDatabaseController {

    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. Search for a Movie");
            io.print("2. Add a movie to the database");
            io.print("3. Remove a moview from the database");
            io.print("4. Edit a movie in the database");
            io.print("5. View all movies in the data base");
            io.print("6. View information about a specific movie");
            io.print("7. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 7);

            switch (menuSelection) {
                case 1:
                    io.print("Search Movie");
                    break;
                case 2:
                    io.print("Add movie");
                    break;
                case 3:
                    io.print("Remove Movie");
                    break;
                case 4:
                    io.print("Edit Movie");
                    break;
                case 5:
                    io.print("List All Movies");
                    break;
                case 6:
                    io.print("List a specific movie");
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
}
