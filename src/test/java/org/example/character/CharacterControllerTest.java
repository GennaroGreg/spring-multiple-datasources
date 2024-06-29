package org.example.character;

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

class CharacterControllerTest {

    @Mock
    private CharacterService characterService;

    @InjectMocks
    private CharacterController characterController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_save() {
        Character character = mock(Character.class);
        when(characterService.save(character)).thenReturn(character);

        ResponseEntity<Character> response = characterController.save(character);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(character, response.getBody());
    }

    @Test
    public void test_getAll() {
        List<Character> characters = Arrays.asList(mock(Character.class), mock(Character.class));
        when(characterService.getAll()).thenReturn(characters);

        ResponseEntity<List<Character>> response = characterController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(characters, response.getBody());
    }

    @Test
    public void test_getById() {
        Character character = mock(Character.class);
        String id = "abc123";
        when(characterService.getById(id)).thenReturn(character);

        ResponseEntity<Character> response = characterController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(character, response.getBody());
    }

    @Test
    public void test_update() {
        Character updatedCharacter = mock(Character.class);
        String id = "abc123";
        when(characterService.update(id, updatedCharacter)).thenReturn(updatedCharacter);

        ResponseEntity<Character> response = characterController.update(id, updatedCharacter);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCharacter, response.getBody());
    }

    @Test
    public void test_delete() {
        Character character = mock(Character.class);
        String id = "abc123";
        when(characterService.delete(id)).thenReturn(character);

        ResponseEntity<String> response = characterController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).startsWith("The following entry has been deleted:"));
    }
}