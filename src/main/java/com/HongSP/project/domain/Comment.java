package com.HongSP.project.domain;

import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.CommentRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId", nullable = false)
    private long commentId;

    @Column(name = "comment_content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", columnDefinition = "BIGINT", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "postid", referencedColumnName = "postid", columnDefinition = "BIGINT", nullable = false)
    private Post post;

    @Builder
    public Comment(CommentRequestDto requestDto){
        this.content = requestDto.getCommentContent();
        this.user = requestDto.getUser();
        this.post = requestDto.getPost();
    }
}
