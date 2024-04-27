package com.HongSP.project.restController;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/posts")
public class PostRestController {

    private PostService postService;

    @GetMapping("/")
    public ResponseEntity<List<PostResponseDto>> getPosts(){
        List<PostResponseDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable("category") Category category) {
        List<Post> posts = postService.getPostsByCategory(category);
        return ResponseEntity.ok(posts);
    }
}