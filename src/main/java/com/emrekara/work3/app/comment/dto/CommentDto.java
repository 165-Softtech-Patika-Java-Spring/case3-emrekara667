package com.emrekara.work3.app.comment.dto;

import lombok.Data;

@Data
public class CommentDto {

    private String description;
    private Long userId;
    private Long productId;
}
