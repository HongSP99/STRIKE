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
            System.out.println("responseDto = " + responseDto);
            return ResponseEntity.ok(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
