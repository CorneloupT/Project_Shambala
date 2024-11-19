package com.Shambala.repositories;

import com.Shambala.models.CharacterStats;
import com.Shambala.repositories.Entity.CharacterEntity;
import com.Shambala.repositories.Entity.CharacterStatEntity;
import com.Shambala.repositories.repoImpl.CharacterStatRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CharacterStatRepoImplTest {

    private EntityManager entityManagerMock;
    private CharacterStats characterStatsMock;
    private CharacterStatEntity characterStatEntityMock;
    private CharacterStatRepositoryImpl characterStatRepository;

    @BeforeEach
    void setUp() {
        entityManagerMock = mock(EntityManager.class);
        characterStatsMock = mock(CharacterStats.class);
        characterStatEntityMock = mock(CharacterStatEntity.class);
        characterStatRepository = new CharacterStatRepositoryImpl();
    }

    @Test
    void testSaveNewCharacterStats_whenStatAreProvided_shouldSaveNewStats() {
        characterStatRepository.entityManager = entityManagerMock;
        doNothing().when(characterStatsMock).exportTo(characterStatEntityMock);

        characterStatRepository.saveNewStat(characterStatsMock);

        verify(entityManagerMock).persist(any(CharacterStatEntity.class));
    }
}
