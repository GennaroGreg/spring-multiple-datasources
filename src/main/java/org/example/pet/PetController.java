package org.example.pet;

import org.example.base.BaseJpaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pet")
public class PetController extends BaseJpaController<Pet, Long> {

    @Autowired
    public PetController(PetService petService) {
        super(petService);
    }
}
