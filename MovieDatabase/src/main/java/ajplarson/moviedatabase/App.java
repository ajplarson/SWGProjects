package ajplarson.moviedatabase;

import controller.MovieDatabaseController;
import dao.MovieDatabaseDao;
import dao.MovieDatabaseDaoFileImpl;
import ui.MovieDatabaseView;
import ui.UserIO;
import ui.UserIOImpl;

/**
 *
 * @author ajplarson
 */
//All the fun happens here
public class App {

    public static void main(String[] args) {

        MovieDatabaseDao myDao = new MovieDatabaseDaoFileImpl();
        UserIO myIo = new UserIOImpl();
        MovieDatabaseView myView = new MovieDatabaseView(myIo);

        MovieDatabaseController movieController = new MovieDatabaseController(myDao, myView);
        movieController.run();
    }
}
