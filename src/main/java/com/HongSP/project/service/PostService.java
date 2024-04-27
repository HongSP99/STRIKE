package com.HongSP.project.service;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.PostRequestDto;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private PostRepository postRepository;
    public List<PostResponseDto> getAllPosts(){
        return postRepository.findAllByOrderByPostIdDesc().stream().map(PostResponseDto::new).toList();
    }

    public List<Post> getPostsByCategory(Category category) {
        return postRepository.findByCategory(category);
    }
}
