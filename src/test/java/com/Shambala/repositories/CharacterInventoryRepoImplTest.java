package com.Shambala.repositories;

import com.Shambala.models.CharacterInventory;
import com.Shambala.repositories.Entity.CharacterInventoryEntity;
import com.Shambala.repositories.repoImpl.CharacterInventoryRepoImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CharacterInventoryRepoImplTest {

    private EntityManager entityManagerMock;
    private CharacterInventory inventoryMock;
    private CharacterInventoryEntity inventoryEntityMock;
    private CharacterInventoryRepoImpl inventoryRepo;

    @BeforeEach
    void setUp() {
        entityManagerMock = mock(EntityManager.class);
        inventoryMock = mock(CharacterInventory.class);
        inventoryEntityMock = mock(CharacterInventoryEntity.class);
        inventoryRepo = new CharacterInventoryRepoImpl();
    }

    @Test
    void testSaveNewInventory_whenNewInventoryIsProvided_shouldSaveIt() {
        inventoryRepo.entityManager = entityManagerMock;
        doNothing().when(inventoryMock).exportInventory(inventoryEntityMock);

        inventoryRepo.saveNewInventory(inventoryMock);

        verify(entityManagerMock).persist(any(CharacterInventoryEntity.class));
    }
}
