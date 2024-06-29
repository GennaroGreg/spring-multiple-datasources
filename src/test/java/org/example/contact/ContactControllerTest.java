package org.example.contact;

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

class ContactControllerTest {

    @Mock
    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_save() {
        Contact contact = mock(Contact.class);
        when(contactService.save(contact)).thenReturn(contact);

        ResponseEntity<Contact> response = contactController.save(contact);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(contact, response.getBody());
    }

    @Test
    public void test_getAll() {
        List<Contact> contacts = Arrays.asList(mock(Contact.class), mock(Contact.class));
        when(contactService.getAll()).thenReturn(contacts);

        ResponseEntity<List<Contact>> response = contactController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(contacts, response.getBody());
    }

    @Test
    public void test_getById() {
        Contact contact = mock(Contact.class);
        Long id = 1L;
        when(contactService.getById(id)).thenReturn(contact);

        ResponseEntity<Contact> response = contactController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(contact, response.getBody());
    }

    @Test
    public void test_update() {
        Contact updatedcontact = mock(Contact.class);
        Long id = 1L;
        when(contactService.update(id, updatedcontact)).thenReturn(updatedcontact);

        ResponseEntity<Contact> response = contactController.update(id, updatedcontact);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedcontact, response.getBody());
    }

    @Test
    public void test_delete() {
        Contact contact = mock(Contact.class);
        Long id = 1L;
        when(contactService.delete(id)).thenReturn(contact);

        ResponseEntity<String> response = contactController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).startsWith("The following entry has been deleted:"));
    }
}