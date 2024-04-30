package com.HongSP.project.domain.post;

import com.HongSP.project.domain.BaseEntity;
import com.HongSP.project.domain.Comment;
import com.HongSP.project.domain.User;
import com.HongSP.project.dto.PostRequestDto;
import com.HongSP.project.dto.UserRequestDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid", nullable = false)
    private long postId;

    @Enumerated(EnumType.STRING)
    @Column(name="category",nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name="team_name",nullable = false)
    private Team teamName;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", columnDefinition = "BIGINT", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.category = requestDto.getCategory();
        this.teamName = requestDto.getTeamName();
        this.user = requestDto.getUser();
    }
}
