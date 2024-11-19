package com.Shambala.repositories.repoImpl;

import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.repositories.CharacterPrincipalStatRepository;
import com.Shambala.repositories.CharacterStatRepository;
import com.Shambala.repositories.Entity.CharacterPrincipalStatEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CharacterPrincipalStatRepositoryImpl implements CharacterPrincipalStatRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void saveNewPrincipalStat(CharacterPrincipalStat characterPrincipalStat) {
        CharacterPrincipalStatEntity entity = new CharacterPrincipalStatEntity();
        characterPrincipalStat.exportTo(entity);
        entityManager.persist(entity);
    }
}
