package com.emrekara.work3.app.comment.service;

import com.emrekara.work3.app.comment.converter.CommentMapper;
import com.emrekara.work3.app.comment.dto.CommentDto;
import com.emrekara.work3.app.comment.dto.CommentSaveRequestDto;
import com.emrekara.work3.app.comment.entity.Comment;
import com.emrekara.work3.app.comment.service.entityservice.CommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentEntityService commentEntityService;

    public CommentDto save(CommentSaveRequestDto commentSaveRequestDto) {
        Comment comment = CommentMapper.INSTANCE.convertToComment(commentSaveRequestDto);

        comment = commentEntityService.save(comment);

        CommentDto commentDto = CommentMapper.INSTANCE.convertToCommentDto(comment);

        return commentDto;
    }

    public void delete(Long id) {
        Comment comment = commentEntityService.getByIdWithControl(id);
        commentEntityService.delete(comment);
    }

    public List<CommentDto> findCommentByUser(Long userId) {

        List<Comment> commentList = commentEntityService.findCommentByUserWithControl(userId);

        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.convertToCommentDtoList(commentList);

        return commentDtoList;
    }
}
