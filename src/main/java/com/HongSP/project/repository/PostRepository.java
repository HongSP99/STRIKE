package com.HongSP.project.repository;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.response.PostResponseDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByPostIdDesc();
    Optional<List<Post>> findAllByCategoryOrderByPostIdDesc(Category category);
    Optional<Post> findByPostId(Long postId);
}
