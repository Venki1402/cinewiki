package com.example.cinewiki.repository;

import com.example.cinewiki.model.Director;
import com.example.cinewiki.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void testFindByDirectorId() {
        // Create a director
        Director director = new Director();
        director.setName("Test Director");
        director.setBirthDate(new Date());
        director.setNationality("Indian");
        director = entityManager.persistAndFlush(director);

        // Create movies
        Movie movie1 = new Movie();
        movie1.setTitle("Test Movie 1");
        movie1.setReleaseYear(2020);
        movie1.setDirector(director);
        entityManager.persistAndFlush(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("Test Movie 2");
        movie2.setReleaseYear(2021);
        movie2.setDirector(director);
        entityManager.persistAndFlush(movie2);

        // Test findByDirectorId
        List<Movie> movies = movieRepository.findByDirectorId(director.getId());
        assertEquals(2, movies.size());
    }

    @Test
    public void testFindAllMoviesWithDirectors() {
        // Create directors
        Director director1 = new Director();
        director1.setName("Director A");
        director1.setBirthDate(new Date());
        director1 = entityManager.persistAndFlush(director1);

        Director director2 = new Director();
        director2.setName("Director B");
        director2.setBirthDate(new Date());
        director2 = entityManager.persistAndFlush(director2);

        // Create movies
        Movie movie1 = new Movie();
        movie1.setTitle("Movie A");
        movie1.setReleaseYear(2019);
        movie1.setDirector(director1);
        entityManager.persistAndFlush(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("Movie B");
        movie2.setReleaseYear(2020);
        movie2.setDirector(director2);
        entityManager.persistAndFlush(movie2);

        // Test custom query
        List<Movie> movies = movieRepository.findAllMoviesWithDirectors();
        assertNotNull(movies);
        assertEquals(2, movies.size());
    }
}

