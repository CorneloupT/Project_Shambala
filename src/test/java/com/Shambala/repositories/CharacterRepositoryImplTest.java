package com.Shambala.repositories;

import com.Shambala.models.Character;
import com.Shambala.repositories.Entity.CharacterEntity;
import com.Shambala.repositories.repoImpl.CharacterRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CharacterRepositoryImplTest {

    private EntityManager entityManagerMock;
    private Character characterMock;
    private CharacterEntity characterEntityMock;
    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setUp() {
        entityManagerMock = mock(EntityManager.class);
        characterMock = mock(Character.class);
        characterEntityMock = mock(CharacterEntity.class);
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void testSaveNewCharacter_shouldSaveCharacter() {
        // Arrange
        // Mock de la classe EntityManager afin de simuler la gestion de la base donnée
        EntityManager entityManagerMock = mock(EntityManager.class);

        // Mock de la classe Character afin de pouvoir utiliser la méthode saveNewCharacter qen simulant un Character en paramètre
        Character characterMock = mock(Character.class);

        // MocK de la classe CharacterEntity afin de simuler la transposition entre la classe Entity et la classe Model dans la base de donnée
        CharacterEntity characterEntityMock = mock(CharacterEntity.class);

        // Appel de la classe CharacterRepositoryImpl afin de pouvoir utiliser ses méthodes
        CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl(entityManagerMock);

        //Export des attributs du Model vers la couche Entity
        doNothing().when(characterMock).exportTo(characterEntityMock);

        //Act
        //appel de la méthode saveNewCharacter
        characterRepository.saveNewCharacter(characterMock);

        // Assert
        // Simulation de la verification de la sauvegarde
        verify(entityManagerMock).persist(any(CharacterEntity.class));
    }

    @Test
    void testGetCharacterById_whenIdIsNull_shouldReturnNullPointerException() {
        characterRepository.entityManager = entityManagerMock;

        NullPointerException characterIdNullException = assertThrows(NullPointerException.class,
                () -> characterRepository.getCharacterById(1L));

        assertEquals("Character ID is null", characterIdNullException.getMessage());
    }

    @Test
    void testGetCharacterById_whenIdIsProvided_shouldReturnCharacterWithThisSpecificId() {
        characterRepository.entityManager = entityManagerMock;

        // on utilise la méthode fin qui consiste a selectionner une class et un attribut (ici l'Id) et de retourné un objet characterEntity simulé
        when(entityManagerMock.find(CharacterEntity.class, 1L)).thenReturn(characterEntityMock);

        // On utilise ce mock pour appeler la méthode toCharacterModel et retourné un objet character simulé
        when(characterEntityMock.toCharacterModel()).thenReturn(characterMock);

        // Appel de la méthode à tester
        Character characterResult = characterRepository.getCharacterById(1L);

        //Validation des résultats
        assertEquals(characterMock, characterResult);
    }
}
