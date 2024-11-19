package com.Shambala.repositories.repoImpl;

import com.Shambala.models.CharacterInventory;
import com.Shambala.repositories.CharacterInventoryRepository;
import com.Shambala.repositories.Entity.CharacterInventoryEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CharacterInventoryRepoImpl implements CharacterInventoryRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void saveNewInventory(CharacterInventory characterInventory) {
        CharacterInventoryEntity entity = new CharacterInventoryEntity();
        characterInventory.exportInventory(entity);
        entityManager.persist(entity);
    }
}
