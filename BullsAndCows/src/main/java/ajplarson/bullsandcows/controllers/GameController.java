package ajplarson.bullsandcows.controllers;

import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Guess;
import ajplarson.bullsandcows.models.GuessResult;
import ajplarson.bullsandcows.models.Round;
import ajplarson.bullsandcows.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService service;

    
    public GameController(GameService service) {
        this.service = service;
    }

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public Game start() {
        return service.start();
    }

    @PutMapping("/guess")
    public GuessResult guess(@RequestBody Guess g) {
        return service.makeGuess(g);
    }

    @GetMapping("/game")
    public List<Game> all() {
        return service.getAllGames();
    }

    @GetMapping("/game/{gameId}")
    public Game game(@PathVariable int gameId) {
        return service.findById(gameId);
    }

    @GetMapping("/rounds/{gameId}")
    public List<Round> rounds(@PathVariable int gameId) {
        return service.getRoundsById(gameId);
    }
}
