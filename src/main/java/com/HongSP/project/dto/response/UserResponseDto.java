package com.HongSP.project.dto.response;

import com.HongSP.project.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private long userId;
    private String userNickname;

    public UserResponseDto(User entity){
        this.userId = entity.getUserId();
        this.userNickname = entity.getUserNickname();
    }
}
