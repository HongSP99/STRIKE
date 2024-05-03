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
        User user = new User(requestDto);
        userRepository.save(user);
        return new UserResponseDto(user);
    }

    @Transactional
    public UserResponseDto loadUserByUserEmail(UserRequestDto requestDto){
        Optional<User> loginUser = userRepository.findByUserEmail(requestDto.getUserEmail());
        if(loginUser.isEmpty()){
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        User user = loginUser.get();
        if(!user.getUserPassword().equals(requestDto.getUserPassword())){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        return new UserResponseDto(user);
    }
}
