package corbos.ghibli.controllers;

import corbos.ghibli.service.CharacterService;
import corbos.ghibli.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

    private final CharacterService characterService;
    private final MovieService movieService;

    public CharacterController(CharacterService characterService, MovieService movieService) {
        this.characterService = characterService;
        this.movieService = movieService;
    }

    @GetMapping("/character/{characterId}")
    public String displayEdit(Model model, @PathVariable int characterId) {
        corbos.ghibli.models.Character ch = characterService.findById(characterId);
        model.addAttribute("character", ch);
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("scenes", movieService.findScenesByMovieId(ch.getMovie().getMovieId()));
        return "character-edit";
    }

    @PostMapping("/character/{characterId}")
    public String editCharacter(corbos.ghibli.models.Character c) {
        c = characterService.save(c);
        return "redirect:/movie/" + c.getMovie().getMovieId();
    }
}
