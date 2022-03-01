package com.emrekara.work3.app.comment.service;

import com.emrekara.work3.app.comment.converter.CommentMapper;
import com.emrekara.work3.app.comment.dto.CommentDto;
import com.emrekara.work3.app.comment.dto.CommentSaveRequestDto;
import com.emrekara.work3.app.comment.entity.Comment;
import com.emrekara.work3.app.comment.service.entityservice.CommentEntityService;
import com.emrekara.work3.app.user.entity.User;
import com.emrekara.work3.app.user.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentEntityService commentEntityService;
    private final UserEntityService userEntityService;

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
        Optional<User>  userOptional = userEntityService.findById(userId);
        String name = userOptional.get().getName();

        List<Comment> commentList = commentEntityService.findCommentByUserWithControl(userId,name);

        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.convertToCommentDtoList(commentList);

        return commentDtoList;
    }

    public List<CommentDto> findCommentByProduct(Long productId) {

        List<Comment> commentList = commentEntityService.findCommentByProductWithControl(productId);

        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.convertToCommentDtoList(commentList);

        return commentDtoList;
    }
}
