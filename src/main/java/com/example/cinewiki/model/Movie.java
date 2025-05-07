package com.example.cinewiki.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 200)
    private String title;

    private Integer releaseYear;

    @Size(max = 100)
    private String genre;

    @Size(max = 1000)
    @Column(length = 1000)
    private String plot;

    private Double budget; // in millions

    private Double boxOffice; // in millions

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    // Default constructor
    public Movie() {}

    // Constructor with fields
    public Movie(String title, Integer releaseYear, String genre, String plot,
                 Double budget, Double boxOffice) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.plot = plot;
        this.budget = budget;
        this.boxOffice = boxOffice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(Double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
