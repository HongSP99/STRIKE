package com.HongSP.project.controller;

import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.service.PostService;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home() {
//        List<PostResponseDto> posts = postService.getAllPosts();// 모든 게시물 가져오기
//        model.addAttribute("posts", posts); // Thymeleaf로 전달하기 위해 모델에 추가
        return "index/home"; // home.html 템플릿으로 이동
    }

    @PostConstruct
    public void init(){

    }
}
