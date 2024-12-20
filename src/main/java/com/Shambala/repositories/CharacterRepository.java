package com.Shambala.repositories;

import com.Shambala.models.Character;

public interface CharacterRepository {
    void saveNewCharacter(Character character);

    Character getCharacterById(Long idCharacter);
}
