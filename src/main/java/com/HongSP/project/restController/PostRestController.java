package com.HongSP.project.restController;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/posts")
public class PostRestController {

    private PostService postService;

    @GetMapping("/rest-api/posts")
    public ResponseEntity<List<Post>> getPostsByCategory(@RequestParam("category") Category category) {
        List<Post> posts = postService.getPostsByCategory(category);
        return ResponseEntity.ok(posts);
    }
}
