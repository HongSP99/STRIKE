package com.HongSP.project.dto.response;

import com.HongSP.project.domain.Comment;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private long commentId;
    private String commentContent;
    private String userNickname;
    private String userEmail;
    private LocalDateTime createdAt;
    private long postId;

    public CommentResponseDto(Comment entity){
        this.commentId = entity.getCommentId();
        this.commentContent = entity.getContent();
        this.userNickname = entity.getUser().getUserNickname();
        this.userEmail = entity.getUser().getUserEmail();
        this.createdAt = entity.getCreatedAt();
        this.postId = entity.getPost().getPostId();
    }
}
