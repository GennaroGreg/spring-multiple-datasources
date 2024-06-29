package org.example.contact;

import org.example.base.BaseJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends BaseJpaService<Contact, Long> {

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        super(contactRepository, Contact.class);
    }
}