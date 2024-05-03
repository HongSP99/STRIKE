package com.HongSP.project.restController;

import com.HongSP.project.domain.User;
import com.HongSP.project.dto.UserRequestDto;
import com.HongSP.project.dto.response.UserResponseDto;
import com.HongSP.project.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/users")
public class UserRestController {
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<?> signupAccount(@RequestBody UserRequestDto requestDto) {
        try {
            UserResponseDto responseDto = userService.signupAccount(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDto requestDto, HttpServletRequest request) {
        try {
            UserResponseDto responseDto = userService.loadUserByUserEmail(requestDto);
            HttpSession session = request.getSession(true);  // 세션이 없으면 생성
            session.setAttribute("userNickname", responseDto.getUserNickname());
            session.setAttribute("userEmail", responseDto.getUserEmail());
            session.setAttribute("loggedIn", true);
            session.setMaxInactiveInterval(1800);
            return ResponseEntity.ok("로그인 성공!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return ResponseEntity.ok("로그아웃되었습니다.");
    }
}
