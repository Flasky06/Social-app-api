package com.bony.user_management.Controllers;

import com.bony.user_management.Services.UserService;
import com.bony.user_management.domain.dto.UserDto;
import com.bony.user_management.domain.entity.User;
import com.bony.user_management.mappers.UserMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDto> listUser(){
        return userService.listUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        User newUser = userService.createUser(
                userMapper.fromDto(userDto)
        );

        return  userMapper.toDto(newUser);
    }
}
