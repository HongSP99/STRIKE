package com.HongSP.project.dto;

import com.HongSP.project.domain.User;
import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private long postId;
    private Category category;
    private Team teamName;
    private String title;
    private String content;
    private User user;
    private String userNickname;


    public void setUser(User user) {
        this.user = user;
        this.userNickname = user.getUserNickname();
    }
}
