package com.bony.user_management.Services.Impl;

import com.bony.user_management.Repository.UserRepository;
import com.bony.user_management.Services.UserService;
import com.bony.user_management.domain.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        if (null!= user.getId()){
            throw new IllegalArgumentException("The User already exists!");
        }
        if (null == user.getName() || user.getName().isBlank()){
            throw new IllegalArgumentException("Name filled must be added !");
        }
        User newUser = new User(
                null,
                user.getName(),
                user.getIdNo(),
                user.getPhoneNo(),
                user.getCounty(),
                user.getDob(),
                user.getGender(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        return userRepository.save(newUser);
    }
}
