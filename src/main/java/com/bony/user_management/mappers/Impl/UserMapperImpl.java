package com.bony.user_management.mappers.Impl;

import com.bony.user_management.domain.dto.UserDto;
import com.bony.user_management.domain.entity.User;
import com.bony.user_management.mappers.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {


    @Override
    public User fromDto(UserDto userDto) {
        return new User(
                userDto.id(),
                userDto.name(),
                userDto.idNo(),
                userDto.phoneNo(),
                userDto.county(),
                userDto.dob(),
                userDto.gender(),
                null,
                null
        );
    }

    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getIdNo(),
                user.getPhoneNo(),
                user.getCounty(),
                user.getDob(),
                user.getGender()
        );
    }
}
