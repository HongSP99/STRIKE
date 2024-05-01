package com.HongSP.project.service;

import com.HongSP.project.domain.User;
import com.HongSP.project.domain.post.Category;
import com.HongSP.project.domain.post.Post;
import com.HongSP.project.dto.PostRequestDto;
import com.HongSP.project.dto.response.PostResponseDto;
import com.HongSP.project.repository.PostRepository;
import com.HongSP.project.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.derived.AnonymousTupleBasicValuedModelPart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<PostResponseDto> getAllPosts(){
        return postRepository.findAllByOrderByPostIdDesc().stream().map(PostResponseDto::new).toList();
    }


    public Optional<List<PostResponseDto>> getPostsByCategory(Category category) {
        return postRepository.findAllByCategoryOrderByPostIdDesc(category)
                .map(boards -> boards.stream().map(PostResponseDto::new).toList());
    }

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto, HttpSession session){
        System.out.println("PostService.createPost");
        String userEmail = (String)session.getAttribute("userEmail");
        User user = userRepository.findByUserEmail(userEmail).orElseThrow(()->new IllegalArgumentException("로그인 하세요"));
        requestDto.setUser(user);
        Post post = new Post(requestDto);
        postRepository.save(post);
        System.out.println("저장 성공!");
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto getPost(long postId){
        System.out.println("PostService.getPost");
        return postRepository.findByPostId(postId).map(PostResponseDto::new).orElseThrow(
                ()->new IllegalArgumentException("게시글 존재하지 않습니다.")
        );
    }


    @Transactional
    public PostResponseDto deletePost(long postId, HttpSession session){
        String userEmail = (String)session.getAttribute("userEmail");
        User user = userRepository.findByUserEmail(userEmail).orElseThrow(()->new IllegalArgumentException("로그인 하세요"));

        Post post = postRepository.findByPostId(postId).orElseThrow(()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        if(!post.getUser().getUserEmail().equals(userEmail)){
            throw new IllegalArgumentException("현재 로그인한 유저는 삭제할 권한이 없습니다.");
        }
        postRepository.delete(post);
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(long postId ,HttpSession session ,PostRequestDto requestDto){
        String userEmail = (String)session.getAttribute("userEmail");
        User user = userRepository.findByUserEmail(userEmail).orElseThrow(()->new IllegalArgumentException("로그인 하세요"));
        Post post =postRepository.findByPostId(postId).orElseThrow(()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        post.setTitle(requestDto.getPostTitle());
        post.setContent(requestDto.getPostContent());
        if(!post.getUser().getUserEmail().equals(user.getUserEmail())){
            throw new IllegalArgumentException("현재 로그인한 유저는 수정할 권한이 없습니다.");
        }
        postRepository.save(post);
        return new PostResponseDto(post);
    }
}
