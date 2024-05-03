package com.HongSP.project.controller;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.repository.PostRepository;
import com.HongSP.project.service.PostService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boards")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts/{category}")
    public String getPostsByCategory(@PathVariable("category") Category category,@PageableDefault(page = 1) Pageable pageable, Model model) {
        Page<PostResponseDto> postsByCategory = postService.getPostsByCategory(category, pageable);

        int blockLimit = 5;
        int startPage = (((int) Math.ceil(((double) pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = Math.min((startPage + blockLimit - 1), postsByCategory.getTotalPages());

        System.out.println("postsByCategory.getTotalPages() = " + postsByCategory.getTotalPages());

        model.addAttribute("categoryName", category.getCategoryName());
        model.addAttribute("category", category.toString());
        model.addAttribute("postsByCategory", postsByCategory);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "post/categoryPosts";
    }

    @GetMapping("/post")
    public String writePost(){
        return "post/writePost";
    }

    @GetMapping("/post/{postId}")
    public String selectByPostId(@PathVariable("postId")long postId, HttpSession session , Model model){
        String userEmail = (String) session.getAttribute("userEmail");
        System.out.println("userEmail = " + userEmail);

        model.addAttribute("postId", postId);
        model.addAttribute("userEmail", userEmail);
        System.out.println("postId = " + postId);

        return "post/postDetail";
    }

    @GetMapping("/post/{postId}/delete")
    public String deletePost(@PathVariable("postId") long postId, Model model){
        model.addAttribute("postId",postId);
        return "post/deletePost";
    }

    @GetMapping("/post/{postId}/edit")
    public String updatePost(@PathVariable("postId")long postId,Model model){
        model.addAttribute("postId",postId);
        return "post/editPost";
    }
}
