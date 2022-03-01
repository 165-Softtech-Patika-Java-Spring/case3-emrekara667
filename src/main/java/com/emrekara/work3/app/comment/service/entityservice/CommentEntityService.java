package com.emrekara.work3.app.comment.service.entityservice;

import com.emrekara.work3.app.comment.dao.CommentDao;
import com.emrekara.work3.app.comment.entity.Comment;
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


    /*
     public Optional<User> findByNameAndPhone(String name, String phone){
        return getDao().findByNameAndTelephoneNumber(name, phone);
    }

    public User getByNameAndPhoneWithControl(User user) {
        Optional<User> userOptional = findByNameAndPhone(user.getName(), user.getTelephoneNumber());

        if(userOptional.isPresent()){
            user = userOptional.get();
        }else{
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
        }
        return user;
    }
     */
}
