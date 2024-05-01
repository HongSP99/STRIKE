package com.HongSP.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
    @GetMapping("/posts/{postId}/comments/{commentId}/delete")
    public String deleteComment(@PathVariable("postId") long postId, @PathVariable("commentId") long commentId, Model model){
        model.addAttribute("postId",postId);
        model.addAttribute("commentId",commentId);
        return "comment/deleteComment";
    }
}
