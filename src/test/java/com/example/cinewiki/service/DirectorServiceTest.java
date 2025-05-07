package com.example.cinewiki.service;

import com.example.cinewiki.model.Director;
import com.example.cinewiki.repository.DirectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DirectorServiceTest {

    @Mock
    private DirectorRepository directorRepository;

    @InjectMocks
    private DirectorService directorService;

    private Director testDirector;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        testDirector = new Director();
        testDirector.setId(1L);
        testDirector.setName("Prashanth Neel");
        testDirector.setBirthDate(new Date());
        testDirector.setNationality("Indian");
    }

    @Test
    public void testGetAllDirectors() {
        List<Director> directorList = new ArrayList<>();
        directorList.add(testDirector);

        when(directorRepository.findAll()).thenReturn(directorList);

        List<Director> result = directorService.getAllDirectors();

        assertEquals(1, result.size());
        assertEquals("Prashanth Neel", result.get(0).getName());
        verify(directorRepository, times(1)).findAll();
    }

    @Test
    public void testGetDirectorById() {
        when(directorRepository.findById(1L)).thenReturn(Optional.of(testDirector));

        Optional<Director> result = directorService.getDirectorById(1L);

        assertTrue(result.isPresent());
        assertEquals("Prashanth Neel", result.get().getName());
        verify(directorRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveDirector() {
        when(directorRepository.save(testDirector)).thenReturn(testDirector);

        Director result = directorService.saveDirector(testDirector);

        assertEquals("Prashanth Neel", result.getName());
        verify(directorRepository, times(1)).save(testDirector);
    }
}
