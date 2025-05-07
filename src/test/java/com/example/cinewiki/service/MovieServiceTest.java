package com.example.cinewiki.service;

import com.example.cinewiki.model.Director;
import com.example.cinewiki.model.Movie;
import com.example.cinewiki.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    private Movie testMovie;
    private Director testDirector;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        testDirector = new Director();
        testDirector.setId(1L);
        testDirector.setName("S.S. Rajamouli");

        testMovie = new Movie();
        testMovie.setId(1L);
        testMovie.setTitle("Baahubali");
        testMovie.setReleaseYear(2015);
        testMovie.setDirector(testDirector);
    }

    @Test
    public void testGetAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(testMovie);

        when(movieRepository.findAll()).thenReturn(movieList);

        List<Movie> result = movieService.getAllMovies();

        assertEquals(1, result.size());
        assertEquals("Baahubali", result.get(0).getTitle());
        verify(movieRepository, times(1)).findAll();
    }

    @Test
    public void testGetMovieById() {
        when(movieRepository.findById(1L)).thenReturn(Optional.of(testMovie));

        Optional<Movie> result = movieService.getMovieById(1L);

        assertTrue(result.isPresent());
        assertEquals("Baahubali", result.get().getTitle());
        verify(movieRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveMovie() {
        when(movieRepository.save(testMovie)).thenReturn(testMovie);

        Movie result = movieService.saveMovie(testMovie);

        assertEquals("Baahubali", result.getTitle());
        verify(movieRepository, times(1)).save(testMovie);
    }

    @Test
    public void testGetMoviesByDirectorId() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(testMovie);

        when(movieRepository.findByDirectorId(1L)).thenReturn(movieList);

        List<Movie> result = movieService.getMoviesByDirectorId(1L);

        assertEquals(1, result.size());
        assertEquals("Baahubali", result.get(0).getTitle());
        verify(movieRepository, times(1)).findByDirectorId(1L);
    }

    @Test
    public void testGetAllMoviesWithDirectors() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(testMovie);

        when(movieRepository.findAllMoviesWithDirectors()).thenReturn(movieList);

        List<Movie> result = movieService.getAllMoviesWithDirectors();

        assertEquals(1, result.size());
        assertEquals("Baahubali", result.get(0).getTitle());
        verify(movieRepository, times(1)).findAllMoviesWithDirectors();
    }
}
