package com.emrekara.work3.app.comment.service.entityservice;

import com.emrekara.work3.app.comment.dao.CommentDao;
import com.emrekara.work3.app.comment.entity.Comment;
import com.emrekara.work3.app.comment.exception.ProductCommentDoNotFoundException;
import com.emrekara.work3.app.comment.exception.UserCommentDoNotFoundException;
import com.emrekara.work3.app.gen.enums.GenErrorMessage;
import com.emrekara.work3.app.gen.exceptions.ItemNotFoundException;
import com.emrekara.work3.app.gen.service.BaseEntityService;
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

    public List<Comment> findCommentByUserWithControl(Long userId,String name){
        Optional<List<Comment>> optionalCommentList = findCommentByUser(userId);

        List<Comment> commentList;
        if(!optionalCommentList.get().isEmpty()){
            commentList = optionalCommentList.get();
        }else{
           // throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
            throw new UserCommentDoNotFoundException(name);
        }
        return commentList;
    }

    public Optional<List<Comment>> findCommentByProduct(Long productId){
        return getDao().findAllByProductId(productId);
    }

    public List<Comment> findCommentByProductWithControl(Long productId, String productName) {
        Optional<List<Comment>> optionalCommentList = findCommentByProduct(productId);

        List<Comment> commentList;
        if(!optionalCommentList.get().isEmpty()){
            commentList = optionalCommentList.get();
        }else{
           //throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
           throw new ProductCommentDoNotFoundException(productName);
        }
        return commentList;
    }

}
