package org.example.contact;

import org.example.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends BaseJpaRepository<Contact, Long> {

}
