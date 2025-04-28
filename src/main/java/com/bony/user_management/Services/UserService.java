package com.bony.user_management.Services;

import com.bony.user_management.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<User> listUsers();

    User createUser (User user);

    Optional<User> getUser(UUID Id);

    User updateUser (UUID userId,User user);

    void deleteUser(UUID userId);


}
