package com.example.cinewiki.repository;

import com.example.cinewiki.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByDirectorId(Long directorId);

    @Query("SELECT m FROM Movie m INNER JOIN m.director d ORDER BY d.name, m.releaseYear DESC")
    List<Movie> findAllMoviesWithDirectors();

}
