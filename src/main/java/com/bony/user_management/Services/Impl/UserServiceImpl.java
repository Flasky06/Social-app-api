package com.bony.user_management.Services.Impl;

import com.bony.user_management.Repository.UserRepository;
import com.bony.user_management.Services.UserService;
import com.bony.user_management.domain.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<User> getUser(UUID Id) {
        return userRepository.findById(Id);
    }

    @Override
    public User updateUser(UUID userId, User user) {
        if (null == user.getId()) {
            throw new IllegalArgumentException("User must have Id");
        }
        if (!Objects.equals(user.getId(), userId)) {
            throw new IllegalArgumentException("Attempting to change UserId not permitted!");
        }
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        foundUser.setName(user.getName());
        foundUser.setIdNo(user.getIdNo());
        foundUser.setPhoneNo(user.getPhoneNo());
        foundUser.setCounty(user.getCounty());
        foundUser.setDob(user.getDob());
        foundUser.setGender(user.getGender());
        foundUser.setUpdated(LocalDateTime.now());

        return userRepository.save(foundUser);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

}
