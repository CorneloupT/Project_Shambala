package com.Shambala.repositories;

import com.Shambala.models.User;
import com.Shambala.repositories.Entity.UserEntity;
import com.Shambala.repositories.repoImpl.UserRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
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
        userRepository.entityManager = entityManagerMock;
    }

    @Test
    void testSaveNewUser_shouldSaveUSer() {
        //Arrange
        doNothing().when(userMock).exportTo(userEntityMock);

        //act
        userRepository.saveNewUser(userMock);

        //Assert
        verify(entityManagerMock).persist(Mockito.any(UserEntity.class));
    }

    @Test
    void testGetUserById_whenUserIdIsNull_shouldReturnNullPointerException() {
        //Arrange
        //Act
        NullPointerException userIdNullException = assertThrows(NullPointerException.class,
                () -> userRepository.getById(1L));

        //Assert
        assertEquals("User ID not found", userIdNullException.getMessage());
    }

    @Test
    void testGetUserById_whenUserIdIsProvided_shouldConvertEntityToModel() {
        when(entityManagerMock.find(UserEntity.class, 1L)).thenReturn(userEntityMock);
        when(userEntityMock.toUserModel()).thenReturn(userMock);

        User userResult = userRepository.getById(1L);

        assertEquals(userMock, userResult);
    }

    @Test
    void testGetUserByName_shouldReturnUserWithSpecificName() {
        when(entityManagerMock.find(UserEntity.class, "Efrim")).thenReturn(userEntityMock);
        when(userEntityMock.toUserModel()).thenReturn(userMock);

        User userResult = userRepository.getByLastName("Efrim");

        assertEquals(userMock, userResult);
    }

    @Test
    void testGetUserByName_whenUserNameIsNull_shouldReturnNullPointerException() {


        NullPointerException nameNullException = assertThrows(NullPointerException.class,
                () -> userRepository.getByLastName("Efrim"));

        assertEquals("User last name is null", nameNullException.getMessage());
    }

}
