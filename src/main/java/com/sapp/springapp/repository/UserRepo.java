package com.sapp.springapp.repository;

import com.sapp.springapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity deleteByUsername(String username);
}
