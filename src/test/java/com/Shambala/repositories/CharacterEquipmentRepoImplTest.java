package com.Shambala.repositories;

import com.Shambala.models.CharacterEquipment;

import com.Shambala.repositories.Entity.CharacterEquipmentEntity;
import com.Shambala.repositories.repoImpl.CharacterEquipmentRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CharacterEquipmentRepoImplTest {

    private EntityManager entityManagerMock;
    private CharacterEquipment equipmentMock;
    private CharacterEquipmentEntity equipmentEntityMock;
    private CharacterEquipmentRepositoryImpl equipmentRepo;

    @BeforeEach
    void setUp() {
        entityManagerMock = mock(EntityManager.class);
        equipmentMock = mock(CharacterEquipment.class);
        equipmentEntityMock = mock(CharacterEquipmentEntity.class);
        equipmentRepo = new CharacterEquipmentRepositoryImpl();
    }

    @Test
    void testSaveNewEquipment_whenNewEquipmentIsProvided_shouldSaveIt() {
        equipmentRepo.entityManager = entityManagerMock;
        doNothing().when(equipmentMock).exportEquipment(equipmentEntityMock);

        equipmentRepo.saveNewEquipment(equipmentMock);

        verify(entityManagerMock).persist(any(CharacterEquipmentEntity.class));
    }
}
