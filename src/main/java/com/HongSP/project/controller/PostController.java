package com.HongSP.project.controller;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.repository.PostRepository;
import com.HongSP.project.service.PostService;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boards")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/lists")
    public String getPostsByCategory(@RequestParam("category") String category, Model model) {
        model.addAttribute("category", category);
        return "post/categoryPosts";
    }

    @GetMapping("/post")
    public String writePost(){
        return "post/writePost";
    }
}
