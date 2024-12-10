package com.Shambala.repositories;

import com.Shambala.models.User;
import com.Shambala.repositories.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
