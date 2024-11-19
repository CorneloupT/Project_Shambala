package com.Shambala.repositories;

import com.Shambala.models.CharacterSubStats;
import com.Shambala.repositories.Entity.CharacterSubStatsEntity;
import com.Shambala.repositories.repoImpl.CharacterSubStatsRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SubStatRepoImplTest {

    private EntityManager entityManagerMock;
    private CharacterSubStats subStatsMock;
    private CharacterSubStatsEntity subStatsEntityMock;
    private CharacterSubStatsRepositoryImpl characterSubStatsRepository;

    @BeforeEach
    void setUp() {
        entityManagerMock = mock(EntityManager.class);
        subStatsMock = mock(CharacterSubStats.class);
        subStatsEntityMock = mock(CharacterSubStatsEntity.class);
        characterSubStatsRepository = new CharacterSubStatsRepositoryImpl();
    }

    @Test
    void testSaveNewSubStat_whenNewSubStatIsProvided_shouldSaveIt() {
        characterSubStatsRepository.entityManager = entityManagerMock;
        doNothing().when(subStatsMock).exportTo(subStatsEntityMock);

        characterSubStatsRepository.saveNewSubStat(subStatsMock);

        verify(entityManagerMock).persist(any(CharacterSubStatsEntity.class));
    }
}
