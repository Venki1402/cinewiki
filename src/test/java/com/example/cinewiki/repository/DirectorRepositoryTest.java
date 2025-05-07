package com.example.cinewiki.repository;

import com.example.cinewiki.model.Director;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DirectorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void testSaveDirector() {
        // Create a director
        Director director = new Director();
        director.setName("S.S. Rajamouli");
        director.setBirthDate(new Date());
        director.setNationality("Indian");
        director.setBiography("Famous Telugu director");

        // Save the director
        Director savedDirector = directorRepository.save(director);

        // Verify the director was saved
        assertNotNull(savedDirector.getId());
        assertEquals("S.S. Rajamouli", savedDirector.getName());
    }

    @Test
    public void testFindDirectorById() {
        // Create a director
        Director director = new Director();
        director.setName("Sukumar");
        director.setBirthDate(new Date());
        director.setNationality("Indian");

        // Save the director
        director = entityManager.persistAndFlush(director);

        // Find the director by ID
        Optional<Director> foundDirector = directorRepository.findById(director.getId());

        // Verify the director was found
        assertTrue(foundDirector.isPresent());
        assertEquals("Sukumar", foundDirector.get().getName());
    }
}
