package com.HongSP.project.dto.response;

import com.HongSP.project.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private long userId;
    private String userEmail;
    private String userPassword;
    private String userNickname;

    public UserResponseDto(User entity){
        this.userId = entity.getUserId();
        this.userEmail = entity.getUserEmail();
        this.userPassword = entity.getUserPassword();
        this.userNickname = entity.getUserNickname();
    }

    @Override
    public String toString(){
        return userId + " " + userNickname;
    }
}
