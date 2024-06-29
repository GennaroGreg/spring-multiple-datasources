package org.example.pet;

import org.example.base.BaseJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService extends BaseJpaService<Pet, Long> {

    @Autowired
    public PetService(PetRepository petRepository) {
        super(petRepository, Pet.class);
    }
}
