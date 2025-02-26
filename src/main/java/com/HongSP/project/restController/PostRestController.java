package com.HongSP.project.restController;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.PostRequestDto;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/boards")
public class PostRestController {

    private final PostService postService;

//    @GetMapping("/posts")
//    public ResponseEntity<Page<PostResponseDto>> getPosts(Pageable pageable) {
//        Page<PostResponseDto> posts = postService.getAllPosts(pageable);
//        return ResponseEntity.ok(posts);
//    }

//    @GetMapping("/{category}")
//    public ResponseEntity<Optional<List<PostResponseDto>>> getPostsByCategory(@PathVariable("category") Category category) {
//        Optional<List<PostResponseDto>> posts = postService.getPostsByCategory(category);
//        if (posts.isPresent()) {
//            return ResponseEntity.ok(posts);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDto requestDto, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            PostResponseDto post = postService.getPost(postService.createPost(requestDto, session).getPostId());
            return ResponseEntity.ok(post);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getPost(@PathVariable("postId") long postId) {
        try{
            PostResponseDto post = postService.getPost(postId);
            return ResponseEntity.ok(post);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("postId") long postId, HttpServletRequest request) {
        try {
            PostResponseDto post=postService.getPost(postId);
            HttpSession session = request.getSession(false);
            postService.deletePost(postId, session);
            return ResponseEntity.ok(post);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<?> editPost(@PathVariable("postId") long postId, HttpServletRequest request, @RequestBody PostRequestDto requestDto) {
        try {
            HttpSession session = request.getSession(false);
            postService.updatePost(postId, session, requestDto);
            PostResponseDto post = postService.getPost(postId);
            return ResponseEntity.ok(post);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}