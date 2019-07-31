package corbos.ghibli.models;

import java.util.ArrayList;
import java.util.List;

public class Character {

    private int characterId;
    private String name;
    private Movie movie;
    private List<Scene> scenes = new ArrayList<>();

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public boolean hasSceneId(int sceneId) {
        return scenes.stream()
                .anyMatch(s -> s.getSceneId() == sceneId);
    }
}
