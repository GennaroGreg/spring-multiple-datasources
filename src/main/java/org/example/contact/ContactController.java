package org.example.contact;

import org.example.base.BaseJpaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contact")
public class ContactController extends BaseJpaController<Contact, Long> {

    @Autowired
    public ContactController(ContactService contactService) {
        super(contactService);
    }
}
