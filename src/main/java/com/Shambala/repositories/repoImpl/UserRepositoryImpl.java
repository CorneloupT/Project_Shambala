package com.Shambala.repositories.repoImpl;

import com.Shambala.models.User;
import com.Shambala.repositories.Entity.UserEntity;
import com.Shambala.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void saveNewUser(User user) {
        UserEntity entity = new UserEntity();
        user.exportTo(entity);
        entityManager.persist(entity);
    }

    @Override
    public User getById(Long idUser) {
        UserEntity entity = entityManager.find(UserEntity.class, idUser);
        if (entity == null) {
            throw new NullPointerException("User ID not found");
        }
        return entity.toUserModel();
    }
}
