package com.Shambala.repositories.repoImpl;

import com.Shambala.models.CharacterSubStats;
import com.Shambala.repositories.CharacterSubStatsRepository;
import com.Shambala.repositories.Entity.CharacterSubStatsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CharacterSubStatsRepositoryImpl implements CharacterSubStatsRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void saveNewSubStat(CharacterSubStats characterSubStats) {
        CharacterSubStatsEntity entity = new CharacterSubStatsEntity();
        characterSubStats.exportTo(entity);
        entityManager.persist(entity);
    }
}
