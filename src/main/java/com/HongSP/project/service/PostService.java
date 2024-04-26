package com.HongSP.project.service;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private PostRepository postRepository;

    public List<Post> getPostsByCategory(Category category) {
        return postRepository.findByCategory(category);
    }
}
