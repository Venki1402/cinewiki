package com.example.cinewiki.controller;

import com.example.cinewiki.model.Director;
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
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService directorService;
    private final MovieService movieService;

    @Autowired
    public DirectorController(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
    }

    // List all directors
    @GetMapping
    public String listDirectors(Model model) {
        model.addAttribute("directors", directorService.getAllDirectors());
        return "director/list";
    }

    // Show form to create a new director
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("director", new Director());
        return "director/form";
    }

    // Process form submission to create a director
    @PostMapping
    public String createDirector(@Valid @ModelAttribute("director") Director director,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "director/form";
        }

        directorService.saveDirector(director);
        return "redirect:/directors";
    }

    // Show form to edit a director
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Director> director = directorService.getDirectorById(id);
        if (director.isPresent()) {
            model.addAttribute("director", director.get());
            return "director/form";
        }
        return "redirect:/directors";
    }

    // Process form submission to update a director
    @PostMapping("/{id}")
    public String updateDirector(@PathVariable Long id,
                                 @Valid @ModelAttribute("director") Director director,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "director/form";
        }

        director.setId(id);
        directorService.saveDirector(director);
        return "redirect:/directors";
    }

    // Show director details including their movies
    @GetMapping("/{id}")
    public String showDirectorDetails(@PathVariable Long id, Model model) {
        Optional<Director> director = directorService.getDirectorById(id);
        if (director.isPresent()) {
            model.addAttribute("director", director.get());
            model.addAttribute("movies", movieService.getMoviesByDirectorId(id));
            return "director/details";
        }
        return "redirect:/directors";
    }
}
