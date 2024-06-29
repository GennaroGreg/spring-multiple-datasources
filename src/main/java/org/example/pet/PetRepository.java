package org.example.pet;

import org.example.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends BaseJpaRepository<Pet, Long> {

}
