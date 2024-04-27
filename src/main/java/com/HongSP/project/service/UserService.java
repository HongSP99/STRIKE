package com.HongSP.project.service;

import com.HongSP.project.domain.User;
import com.HongSP.project.dto.UserRequestDto;
import com.HongSP.project.dto.response.UserResponseDto;
import com.HongSP.project.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public UserResponseDto signupAccount(UserRequestDto requestDto){
        String userEmail =requestDto.getUserEmail();
        String userNickname = requestDto.getUserNickname();
        String userPassword = requestDto.getUserPassword();

        User user = new User(requestDto);
        userRepository.save(user);
        return new UserResponseDto(user);
    }
}
