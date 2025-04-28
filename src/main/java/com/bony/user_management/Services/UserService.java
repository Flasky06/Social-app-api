package com.bony.user_management.Services;

import com.bony.user_management.domain.entity.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User createUser (User user);
}
