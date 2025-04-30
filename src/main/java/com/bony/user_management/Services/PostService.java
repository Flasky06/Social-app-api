package com.bony.user_management.Services;

import com.bony.user_management.domain.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService {
    List<Post> listPosts();

    Post createPost(Post post);

    Optional<Post> getPost(UUID postId);

    Post updatePost (UUID postId,Post post);

    void deletePost (UUID postId);
}
