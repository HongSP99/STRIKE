package com.HongSP.project.dto.response;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.domain.post.Team;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private long postId;
    private String postTitle;
    private String postContent;
    private String userNickname;
    private String userEmail;
    private Category category;
    private Team teamName;
    private LocalDateTime createdAt;

    public PostResponseDto(Post entity){
        this.postId = entity.getPostId();
        this.postTitle = entity.getTitle();
        this.postContent = entity.getContent();
        this.userNickname = entity.getUser().getUserNickname();
        this.userEmail = entity.getUser().getUserEmail();
        this.createdAt = entity.getCreatedAt();
        this.category = entity.getCategory();
        this.teamName = entity.getTeamName();
    }
}
