package com.emrekara.work3.app.comment.dao;

import com.emrekara.work3.app.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

    Optional<List<Comment>> findAllByUserId(Long userId);
}
