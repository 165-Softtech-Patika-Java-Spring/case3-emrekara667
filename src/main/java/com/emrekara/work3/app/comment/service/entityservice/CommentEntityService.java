package com.emrekara.work3.app.comment.service.entityservice;

import com.emrekara.work3.app.comment.dao.CommentDao;
import com.emrekara.work3.app.comment.entity.Comment;
import com.emrekara.work3.app.gen.enums.GenErrorMessage;
import com.emrekara.work3.app.gen.exceptions.ItemNotFoundException;
import com.emrekara.work3.app.gen.service.BaseEntityService;
import com.emrekara.work3.app.user.exception.UserNotMatchException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentDao> {

    public CommentEntityService(CommentDao dao) {
        super(dao);
    }

    public Optional<List<Comment>> findCommentByUser(Long userId) {
        return getDao().findAllByUserId(userId);
    }

    public List<Comment> findCommentByUserWithControl(Long userId){
        Optional<List<Comment>> optionalCommentList = findCommentByUser(userId);

        List<Comment> commentList;
        if(!optionalCommentList.get().isEmpty()){
            commentList = optionalCommentList.get();
        }else{
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
        }
        return commentList;
    }

    public Optional<List<Comment>> findCommentByProduct(Long productId){
        return getDao().findAllByProductId(productId);
    }

    public List<Comment> findCommentByProductWithControl(Long productId) {
        Optional<List<Comment>> optionalCommentList = findCommentByProduct(productId);

        List<Comment> commentList;
        if(!optionalCommentList.get().isEmpty()){
            commentList = optionalCommentList.get();
        }else{
           throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);

        }
        return commentList;
    }

}
