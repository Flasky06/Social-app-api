package com.bony.user_management.mappers;

import com.bony.user_management.domain.dto.PostDto;
import com.bony.user_management.domain.entity.Post;

public interface PostMapper {

    Post fromDto(PostDto postDto);
    PostDto toDto(Post post);
}
