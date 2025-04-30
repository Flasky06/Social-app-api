package com.bony.user_management.domain.dto;

import java.util.UUID;

public record PostDto(UUID postId, String title, String message) {
}
