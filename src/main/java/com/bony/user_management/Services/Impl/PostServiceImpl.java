package com.bony.user_management.Services.Impl;

import com.bony.user_management.Repository.PostRepository;
import com.bony.user_management.Services.PostService;
import com.bony.user_management.domain.entity.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> listPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        if (null != post.getPostId()){
            throw new IllegalArgumentException("Posts with this Id already exists!");
        }

        if (null == post.getTitle()){
            throw new IllegalArgumentException("Post must have title !");
        }

        Post newPost= new Post(
                null,
                post.getTitle(),
                post.getMessage(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        return postRepository.save(newPost);
    }

    @Override
    public Optional<Post> getPost(UUID postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Post updatePost(UUID postId, Post post) {
        return null;
    }

    @Override
    public void deletePost(UUID postId) {
         postRepository.deleteById(postId);
    }


}
