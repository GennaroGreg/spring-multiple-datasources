package org.example.character;

import org.example.base.BaseMongoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/character")
public class CharacterController extends BaseMongoController<Character, String> {

    @Autowired
    public CharacterController(CharacterService characterService) {
        super(characterService);
    }
}
