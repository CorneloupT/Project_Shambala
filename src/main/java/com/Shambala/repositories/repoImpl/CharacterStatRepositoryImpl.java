package com.Shambala.repositories.repoImpl;

import com.Shambala.models.CharacterStats;
import com.Shambala.repositories.CharacterStatRepository;
import com.Shambala.repositories.Entity.CharacterStatEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CharacterStatRepositoryImpl implements CharacterStatRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void saveNewStat(CharacterStats characterStats) {
        CharacterStatEntity entity = new CharacterStatEntity();
        characterStats.exportTo(entity);
        entityManager.persist(entity);
    }
}
