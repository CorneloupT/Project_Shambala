package com.Shambala.repositories.repoImpl;

import com.Shambala.models.Character;
import com.Shambala.repositories.CharacterRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CharacterRepositoryImpl implements CharacterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Character saveNewCharacter(Character character) {
        return character;
    }
}
