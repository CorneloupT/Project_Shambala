package com.Shambala.repositories;

import com.Shambala.models.User;

public interface UserRepository {
    void saveNewUser(User user);

    User getById(Long idUser);

    User getByLastName(String name);

    void deleteUserById(User user);

    void updateUser(User user);

    User getUserByEmail(String mail);
}
