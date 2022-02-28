package com.emrekara.work3.app.comment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
public class Comment {

    @Id
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    @GeneratedValue(generator = "Comment")
    private Long id;

    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "ID_PRODUCT")
    private Long productId;
}
