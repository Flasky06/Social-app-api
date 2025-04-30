package com.bony.user_management.Controllers;

import com.bony.user_management.Services.PostService;
import com.bony.user_management.domain.dto.PostDto;
import com.bony.user_management.domain.entity.Post;
import com.bony.user_management.mappers.PostMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/posts")
class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping
    public List<PostDto> listPosts(){
        return postService.listPosts()
                .stream()
                .map(postMapper::toDto)
                .toList();
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto){
        Post createdPost = postService.createPost(
                postMapper.fromDto(postDto)
        );

        return postMapper.toDto(createdPost);
    }

    @GetMapping(path = "/{postId}")
    public Optional<PostDto> getPost(@PathVariable("postId") UUID postID) {
        return postService.getPost(postID).map(postMapper::toDto);
    }

    @DeleteMapping(path = "/{postId}")
    public void deletePost(@PathVariable("postId") UUID postID) {
        postService.deletePost(postID);
    }
}
