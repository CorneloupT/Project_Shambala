package com.Shambala.models;

public interface UserPort {
    void saveNewUser(User user);

    User getById(Long idUser);

    User getByLastName(String name);

    void deleteUserById(User user);

    void updateUser(User user);

    User getUserByEmail(String mail);
}
