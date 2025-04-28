package com.bony.user_management.mappers;

import com.bony.user_management.domain.dto.UserDto;
import com.bony.user_management.domain.entity.User;

public interface UserMapper {
    User fromDto(UserDto userDto);
    UserDto toDto(User user);

}
