package com.HongSP.project.repository;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByPostIdDesc();
    List<Post> findByCategory(Category category);
}
