package com.emrekara.work3.app.user.service.entityservice;

import com.emrekara.work3.app.gen.service.BaseEntityService;
import com.emrekara.work3.app.user.dao.UserDao;
import com.emrekara.work3.app.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService extends BaseEntityService<User, UserDao> {

    public UserEntityService(UserDao dao) {
        super(dao);
    }

    public User getByName(String name) {
       return getDao().findByName(name);
    }

}
