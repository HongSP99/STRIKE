package com.HongSP.project.restController;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.PostRequestDto;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/boards")
public class PostRestController {

    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDto>> getPosts() {
        List<PostResponseDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<PostResponseDto>> getPostsByCategory(@PathVariable("category") Category category) {
        List<PostResponseDto> posts = postService.getPostsByCategory(category);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDto requestDto, HttpServletRequest request) {
        System.out.println("PostRestController.createPost");
        try {
            HttpSession session = request.getSession(false);
            PostResponseDto post = postService.getPost(postService.createPost(requestDto, session).getPostId());
            return ResponseEntity.ok(post);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}