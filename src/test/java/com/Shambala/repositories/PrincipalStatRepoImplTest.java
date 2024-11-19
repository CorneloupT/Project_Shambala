package com.Shambala.repositories;

import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.repositories.Entity.CharacterPrincipalStatEntity;
import com.Shambala.repositories.repoImpl.CharacterPrincipalStatRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PrincipalStatRepoImplTest {

    private EntityManager entityManagerMock;
    private CharacterPrincipalStat principalStatMock;
    private CharacterPrincipalStatEntity principalStatEntityMock;
    private CharacterPrincipalStatRepositoryImpl principalStatRepository;

    @BeforeEach
    void setUp() {
        entityManagerMock = mock(EntityManager.class);
        principalStatMock = mock(CharacterPrincipalStat.class);
        principalStatEntityMock = mock(CharacterPrincipalStatEntity.class);
        principalStatRepository = new CharacterPrincipalStatRepositoryImpl();
    }

    @Test
    void testSaveNewPrincipalStat_whenNewPrincipalStatIsProvided_shouldSaveIt() {
        principalStatRepository.entityManager = entityManagerMock;
        doNothing().when(principalStatMock).exportTo(principalStatEntityMock);

        principalStatRepository.saveNewPrincipalStat(principalStatMock);

        verify(entityManagerMock).persist(any(CharacterPrincipalStatEntity.class));
    }
}
