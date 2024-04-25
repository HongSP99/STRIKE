package com.HongSP.project.domain;

import com.HongSP.project.domain.post.Post;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId", nullable = false)
    private long commentId;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", columnDefinition = "BIGINT", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "postid", referencedColumnName = "postid", columnDefinition = "BIGINT", nullable = false)
    private Post post;
}
