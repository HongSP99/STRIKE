package com.HongSP.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private long userId;
    private String userEmail;
    private String userPassword;
    private String userNickname;
}
