package com.HongSP.project.service;

import com.HongSP.project.domain.User;
import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.PostRequestDto;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.repository.PostRepository;
import com.HongSP.project.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.derived.AnonymousTupleBasicValuedModelPart;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public List<PostResponseDto> getAllPosts(){
        return postRepository.findAllByOrderByPostIdDesc().stream().map(PostResponseDto::new).toList();
    }

    public List<PostResponseDto> getPostsByCategory(Category category) {
        return postRepository.findByCategory(category).stream().map(PostResponseDto::new).toList();
    }

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto, HttpSession session){
        System.out.println("PostService.createPost");
        String userEmail = (String)session.getAttribute("userEmail");
        System.out.println("userEmail = " + userEmail);
        User user = userRepository.findByUserEmail(userEmail).orElseThrow(()->new IllegalArgumentException("로그인 하세요"));
        requestDto.setUser(user);
        Post post = new Post(requestDto);
        postRepository.save(post);
        System.out.println("저장 성공!");
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto getPost(Long postNum){
        System.out.println("PostService.getPost");
        return postRepository.findByPostId(postNum).map(PostResponseDto::new).orElseThrow(
                ()->new IllegalArgumentException("게시글 존재하지 않습니다.")
        );
    }
}
