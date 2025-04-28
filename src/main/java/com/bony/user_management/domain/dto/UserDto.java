package com.bony.user_management.domain.dto;

import com.bony.user_management.domain.entity.Gender;

import java.time.LocalDate;
import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        Long idNo, Long phoneNo, String county, LocalDate dob, Gender gender) {

}
