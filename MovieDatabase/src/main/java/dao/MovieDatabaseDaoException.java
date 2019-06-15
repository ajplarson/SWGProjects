package dao;

/**
 *
 * @author Andrew
 */
public class MovieDatabaseDaoException extends Exception {

    //application based specific error
    public MovieDatabaseDaoException(String message) {
        super(message); //because inheritance
    }

    //underlying exception error
    public MovieDatabaseDaoException(String message, Throwable cause) {
        super(message, cause); //because inheritance
    }

}
