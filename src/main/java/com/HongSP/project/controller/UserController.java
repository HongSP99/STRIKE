package com.HongSP.project.controller;

import com.HongSP.project.dto.UserRequestDto;
import com.HongSP.project.dto.response.UserResponseDto;
import com.HongSP.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login"; // login.html 템플릿으로 이동
    }

    @GetMapping("/signup")
    public String signUp(){
        return "user/register";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/users/login";
    }
}
