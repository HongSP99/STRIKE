package com.HongSP.project.dto.response;

import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.domain.post.Team;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private long postId;
    private String postTitle;
    private String postContent;
    private String userNickname;
    private Category category;
    private Team team;
    private LocalDateTime createdAt;

    public PostResponseDto(Post entity){
        this.postId = entity.getPostId();
        this.postTitle = entity.getTitle();
        this.postContent = entity.getContent();
        this.userNickname = entity.getUser().getUserNickname();
        this.createdAt = entity.getCreatedDate();
        this.category = entity.getCategory();
        this.team = entity.getTeamName();
    }
}
