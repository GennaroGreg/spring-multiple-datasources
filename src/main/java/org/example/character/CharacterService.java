package org.example.character;

import org.example.base.BaseMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService extends BaseMongoService<Character, String> {

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        super(characterRepository, Character.class);
    }
}
