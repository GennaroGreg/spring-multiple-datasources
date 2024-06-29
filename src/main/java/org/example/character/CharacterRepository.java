package org.example.character;

import org.example.base.BaseMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends BaseMongoRepository<Character, String> {

}
