package corbos.ghibli.service;

import corbos.ghibli.data.CharacterDao;
import corbos.ghibli.data.MovieDao;
import corbos.ghibli.data.SceneDao;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    
    private final MovieDao movieDao;
    private final CharacterDao characterDao;
    private final SceneDao sceneDao;
    
    public CharacterService(MovieDao movieDao, CharacterDao characterDao, SceneDao sceneDao) {
        this.movieDao = movieDao;
        this.characterDao = characterDao;
        this.sceneDao = sceneDao;
    }
    
    public corbos.ghibli.models.Character findById(int characterId) {
        corbos.ghibli.models.Character result = characterDao.findById(characterId);
        result.setMovie(movieDao.findByCharacterId(characterId));
        result.setScenes(sceneDao.findByCharacterId(characterId));
        return result;
    }
    
    public corbos.ghibli.models.Character save(corbos.ghibli.models.Character character) {
        return character;
    }
}
