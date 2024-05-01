package com.HongSP.project.dto;

import com.HongSP.project.domain.User;
import com.HongSP.project.domain.post.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private long commentId;
    private String commentContent;
    private User user;
    private String userNickname;
    private Post post;
    private Long postId;

    public void setUser(User user) {
        this.user = user;
        this.userNickname = user.getUserNickname();
    }
}
