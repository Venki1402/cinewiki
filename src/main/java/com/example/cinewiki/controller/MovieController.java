package com.example.cinewiki.controller;

import com.example.cinewiki.model.Movie;
import com.example.cinewiki.service.DirectorService;
import com.example.cinewiki.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final DirectorService directorService;

    @Autowired
    public MovieController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    // List all movies
    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMoviesWithDirectors());
        return "movie/list";
    }

    // Show form to create a new movie
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("directors", directorService.getAllDirectors());
        return "movie/form";
    }

    // Process form submission to create a movie
    @PostMapping
    public String createMovie(@Valid @ModelAttribute("movie") Movie movie,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("directors", directorService.getAllDirectors());
            return "movie/form";
        }

        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Show form to edit a movie
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            model.addAttribute("directors", directorService.getAllDirectors());
            return "movie/form";
        }
        return "redirect:/movies";
    }

    // Process form submission to update a movie
    @PostMapping("/{id}")
    public String updateMovie(@PathVariable Long id,
                              @Valid @ModelAttribute("movie") Movie movie,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("directors", directorService.getAllDirectors());
            return "movie/form";
        }

        movie.setId(id);
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Show movie details
    @GetMapping("/{id}")
    public String showMovieDetails(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            return "movie/details";
        }
        return "redirect:/movies";
    }
}
