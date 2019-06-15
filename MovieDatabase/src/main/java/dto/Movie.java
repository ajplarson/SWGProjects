package dto;

/**
 *
 * @author ajplarson
 */
public class Movie {

    private String title;
    private String releaseDate; //Format: MM/DD/YY
    private String mpaaRating;
    private String directorName; //first and last name
    private String studio;
    private String userRating; //number of stars out of five
    private int movieIndex; //assigned when added

    public int getMovieIndex() {
        return movieIndex;
    }

    public void setMovieIndex(int movieIndex) {
        this.movieIndex = movieIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

}
