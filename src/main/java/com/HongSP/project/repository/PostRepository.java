package com.HongSP.project.repository;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByOrderByPostIdDesc(Pageable pageable);
    Page<Post> findAllByCategoryOrderByPostIdDesc(Category category, Pageable pageable);
    Optional<Post> findByPostId(Long postId);
}
