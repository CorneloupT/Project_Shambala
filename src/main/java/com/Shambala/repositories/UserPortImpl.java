package com.Shambala.repositories;

import com.Shambala.models.User;
import com.Shambala.models.UserPort;
import com.Shambala.repositories.Entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserPortImpl implements UserPort {

    private final UserRepository userRepository;

    public UserPortImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveNewUser(User user) {
        UserEntity userToSave = new UserEntity();
        user.exportTo(userToSave);
        userRepository.save(userToSave);
    }

    @Override
    public User getById(Long idUser) {
        return userRepository.findById(idUser).get().toUserModel();
    }

    @Override
    public User getByLastName(String name) {
        return null;
    }

    @Override
    public void deleteUserById(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUserByEmail(String mail) {
        return null;
    }
}
