package com.bony.user_management.mappers.Impl;

import com.bony.user_management.domain.dto.PostDto;
import com.bony.user_management.domain.entity.Post;
import com.bony.user_management.mappers.PostMapper;
import org.springframework.stereotype.Component;

@Component
public class PostMapperImp implements PostMapper {
    @Override
    public Post fromDto(PostDto postDto) {
        return new Post(
                postDto.postId(),
                postDto.title(),
                postDto.message(),
                null,
                null
        );
    }

    @Override
    public PostDto toDto(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getTitle(),
                post.getTitle()
        );
    }
}
