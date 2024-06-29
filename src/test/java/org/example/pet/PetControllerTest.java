package org.example.pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetControllerTest {

    @Mock
    private PetService petService;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_save() {
        Pet pet = mock(Pet.class);
        when(petService.save(pet)).thenReturn(pet);

        ResponseEntity<Pet> response = petController.save(pet);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(pet, response.getBody());
    }

    @Test
    public void test_getAll() {
        List<Pet> pets = Arrays.asList(mock(Pet.class), mock(Pet.class));
        when(petService.getAll()).thenReturn(pets);

        ResponseEntity<List<Pet>> response = petController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pets, response.getBody());
    }

    @Test
    public void test_getById() {
        Pet pet = mock(Pet.class);
        Long id = 1L;
        when(petService.getById(id)).thenReturn(pet);

        ResponseEntity<Pet> response = petController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pet, response.getBody());
    }

    @Test
    public void test_update() {
        Pet updatedPet = mock(Pet.class);
        Long id = 1L;
        when(petService.update(id, updatedPet)).thenReturn(updatedPet);

        ResponseEntity<Pet> response = petController.update(id, updatedPet);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPet, response.getBody());
    }

    @Test
    public void test_delete() {
        Pet pet = mock(Pet.class);
        Long id = 1L;
        when(petService.delete(id)).thenReturn(pet);

        ResponseEntity<String> response = petController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).startsWith("The following entry has been deleted:"));
    }
}