package com.HongSP.project.controller;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.repository.PostRepository;
import com.HongSP.project.service.PostService;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/board/lists")
    public String getPostsByCategory(@RequestParam("category") Category category, Model model) {
        List<Post> posts = postService.getPostsByCategory(category);
        model.addAttribute("posts", posts);
        return "board-list";  // Thymeleaf template 이름
    }
}
