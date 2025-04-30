package com.bony.user_management.Repository;

import com.bony.user_management.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post , UUID> {
}
