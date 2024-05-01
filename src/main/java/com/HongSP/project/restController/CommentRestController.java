package com.HongSP.project.restController;

import com.HongSP.project.dto.CommentRequestDto;
import com.HongSP.project.dto.response.CommentResponseDto;
import com.HongSP.project.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentRestController {
    private final CommentService commentService;

    @PostMapping("/rest-api/posts/{postId}/comments")
    public ResponseEntity<?> writeComment(@PathVariable("postId") long postId, @RequestBody CommentRequestDto requestDto
                                            , HttpServletRequest request) {
        try{
            HttpSession session = request.getSession(false);
            CommentResponseDto commentResponseDto = commentService.writeComment(postId,requestDto, session);
            return ResponseEntity.ok(commentResponseDto);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/rest-api/posts/{postId}/comments")
    public ResponseEntity<?> readComments(@PathVariable("postId") long postId){
        List<CommentResponseDto> commentResponseDtoList=commentService.readComments(postId);
        return ResponseEntity.ok(commentResponseDtoList);
    }
}
