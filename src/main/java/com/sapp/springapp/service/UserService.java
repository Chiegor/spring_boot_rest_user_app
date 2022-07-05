package com.sapp.springapp.service;

import com.sapp.springapp.entity.UserEntity;
import com.sapp.springapp.exception.UserAlreadyExistException;
import com.sapp.springapp.exception.UserNotFoundException;
import com.sapp.springapp.model.User;
import com.sapp.springapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User already exist");
        }
        return userRepo.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }

    public Long deleteUserById(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
