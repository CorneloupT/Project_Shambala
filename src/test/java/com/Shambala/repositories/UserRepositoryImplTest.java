package com.Shambala.repositories;

import com.Shambala.models.User;
import com.Shambala.repositories.Entity.UserEntity;
import com.Shambala.repositories.repoImpl.UserRepositoryImpl;
import jakarta.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserRepositoryImplTest {

    private EntityManager entityManagerMock;
    private User userMock;
    private UserEntity userEntityMock;
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
        entityManagerMock = mock(EntityManager.class);
        userMock = mock(User.class);
        userEntityMock = mock(UserEntity.class);
        userRepository = new UserRepositoryImpl();
    }

    @Test
    void testSaveNewUser_shouldSaveUSer() {
        //Arrange
        userRepository.entityManager = entityManagerMock;
        doNothing().when(userMock).exportTo(userEntityMock);

        //act
        userRepository.saveNewUser(userMock);

        //Assert
        verify(entityManagerMock).persist(Mockito.any(UserEntity.class));
    }

    @Test
    void testGetUserById_whenUserIdIsNull_shouldReturnNullPointerException() {
        //Arrange
        userRepository.entityManager = entityManagerMock;
        //Act
        NullPointerException userIdNullException = assertThrows(NullPointerException.class,
                () -> userRepository.getById(1L));

        //Assert
        assertEquals("Character ID not found", userIdNullException.getMessage());
    }

    @Test
    void testGetUserById_whenUserIdIsProvided_shouldConvertEntityToModel() {
        userRepository.entityManager = entityManagerMock;
        when(entityManagerMock.find(UserEntity.class, 1L)).thenReturn(userEntityMock);
        when(userEntityMock.toUserModel()).thenReturn(userMock);

        User userResult = userRepository.getById(1L);

        assertEquals(userMock, userResult);
    }
}
