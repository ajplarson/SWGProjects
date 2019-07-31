package corbos.ghibli.controllers;

import corbos.ghibli.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String displayMain(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "blockbuster";
    }

    @GetMapping("/movie/{movieId}")
    public String displayMovie(Model model, @PathVariable int movieId) {
        model.addAttribute("movie", movieService.findById(movieId));
        return "movie-details";
    }
    
    @GetMapping("/movie/add")
    public String postMovie() {
        return "add";
    }
    
    @PostMapping("/movie/add")
    public String postMovie(Model model, String title, String url) {
        model.addAttribute("movie", movieService.add(title, url));
        return "redirect:/";
    }
}
