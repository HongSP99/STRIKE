package com.HongSP.project.service;

import com.HongSP.project.domain.Comment;
import com.HongSP.project.domain.User;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.CommentRequestDto;
import com.HongSP.project.dto.response.CommentResponseDto;
import com.HongSP.project.repository.CommentRepository;
import com.HongSP.project.repository.PostRepository;
import com.HongSP.project.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final UserRepository userRepository;
    private final PostRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponseDto writeComment(long postId, CommentRequestDto requestDto, HttpSession session){
        String userEmail = (String)session.getAttribute("userEmail");
        User user=userRepository.findByUserEmail(userEmail).orElseThrow(()->new IllegalArgumentException("로그인 하세요"));
        requestDto.setUser(user);
        Post post=boardRepository.findByPostId(postId).orElseThrow(()->new IllegalArgumentException("게시글이 존재하지 않습니다."));
        requestDto.setPost(post);
        Comment comment=new Comment(requestDto);
        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }

    @Transactional
    public List<CommentResponseDto> readComments(long postId){
        return commentRepository.findByPostPostIdOrderByCreatedAtDesc(postId).stream().map(CommentResponseDto::new).toList();
    }
}
