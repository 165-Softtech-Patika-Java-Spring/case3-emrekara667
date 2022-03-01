package com.emrekara.work3.app.comment.controller;

import com.emrekara.work3.app.comment.dto.CommentDto;
import com.emrekara.work3.app.comment.dto.CommentSaveRequestDto;
import com.emrekara.work3.app.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity save(@RequestBody CommentSaveRequestDto commentSaveRequestDto){
        CommentDto commentDto = commentService.save(commentSaveRequestDto);

        return ResponseEntity.ok(commentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        commentService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }


}
