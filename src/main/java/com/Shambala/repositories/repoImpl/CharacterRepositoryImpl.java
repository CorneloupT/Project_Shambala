package com.Shambala.repositories.repoImpl;

import com.Shambala.models.Character;
import com.Shambala.repositories.CharacterRepository;
import com.Shambala.repositories.Entity.CharacterEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CharacterRepositoryImpl implements CharacterRepository {

    private final EntityManager entityManager;

    public CharacterRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveNewCharacter(Character character) {
        CharacterEntity entity = new CharacterEntity();
        character.exportTo(entity);
        entityManager.persist(entity);
    }

    @Override
    public Character getCharacterById(Long idCharacter) {
        CharacterEntity entity = entityManager.find(CharacterEntity.class, idCharacter);
        if (entity == null) {
            throw new NullPointerException("Character ID is null");
        }
        return entity.toCharacterModel();
    }
    
}
