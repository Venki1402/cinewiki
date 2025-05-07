package com.example.cinewiki.service;

import com.example.cinewiki.model.Director;
import com.example.cinewiki.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
}
