package corbos.ghibli.service;

import corbos.ghibli.data.CharacterDao;
import corbos.ghibli.data.MovieDao;
import corbos.ghibli.data.SceneDao;
import corbos.ghibli.models.Movie;
import corbos.ghibli.models.Scene;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieDao movieDao;
    private final CharacterDao characterDao;
    private final SceneDao sceneDao;

    public MovieService(MovieDao movieDao, CharacterDao characterDao, SceneDao sceneDao) {
        this.movieDao = movieDao;
        this.characterDao = characterDao;
        this.sceneDao = sceneDao;
    }

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public Movie findById(int movieId) {
        Movie movie = movieDao.findById(movieId);
        movie.setCharacters(characterDao.findByMovieId(movieId));
        return movie;
    }

    public List<Scene> findScenesByMovieId(int movieId) {
        return sceneDao.findByMovieId(movieId);
    }
    
    public Movie add (String title, String posterUrl) {
        return movieDao.addMovie(title, posterUrl);
    }
}
