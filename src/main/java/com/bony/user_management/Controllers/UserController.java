package com.bony.user_management.Controllers;

import com.bony.user_management.Services.UserService;
import com.bony.user_management.domain.dto.UserDto;
import com.bony.user_management.domain.entity.User;
import com.bony.user_management.mappers.UserMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public List<UserDto> listUser() {
        return userService.listUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User newUser = userService.createUser(
                userMapper.fromDto(userDto)
        );

        return userMapper.toDto(newUser);
    }


    @GetMapping(path = "/{user_id}")
    public Optional<UserDto> getUser(@PathVariable("user_id") UUID userId) {
        return userService.getUser(userId).map(userMapper::toDto);
    }

    @PutMapping(path = "/{user_id}")
    public UserDto updateUser(
            @PathVariable("user_id") UUID userId,
            @RequestBody UserDto userDto
    ) {
        User updatedUser = userService.updateUser(userId, userMapper.fromDto(userDto));
        return userMapper.toDto(updatedUser);
    }

    @DeleteMapping(path = "/{user_id}")
    public void  deleteUser(@PathVariable("user_id") UUID userId) {
        userService.deleteUser(userId);
    }


}
