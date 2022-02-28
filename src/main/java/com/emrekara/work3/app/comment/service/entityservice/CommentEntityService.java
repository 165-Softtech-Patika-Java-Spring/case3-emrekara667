package com.emrekara.work3.app.comment.service.entityservice;

import com.emrekara.work3.app.comment.dao.CommentDao;
import com.emrekara.work3.app.comment.entity.Comment;
import com.emrekara.work3.app.gen.service.BaseEntityService;
import com.emrekara.work3.app.user.dao.UserDao;
import com.emrekara.work3.app.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentDao> {

    public CommentEntityService(CommentDao dao) {
        super(dao);
    }
}
