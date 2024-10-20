package com.Shambala.repositories.repoImpl;

import com.Shambala.models.Character;
import com.Shambala.repositories.CharacterRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

class CharacterRepositoryImpl implements CharacterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveNewCharacter(Character character) {
        CharacterEntity entity = new CharacterEntity();
        character.exportTo(entity);
        entityManager.persist(entity);
    }

    @Override
    public Character getById(Long idCharacter) {
        // TODO attention au NPE
        CharacterEntity entity = entityManager.find(CharacterEntity.class, idCharacter);
        return entity.toCharacterModel();
    }
    
}
