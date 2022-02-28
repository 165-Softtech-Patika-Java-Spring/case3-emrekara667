package com.emrekara.work3.app.user.service;

import com.emrekara.work3.app.user.converter.UserMapper;
import com.emrekara.work3.app.user.dto.UserDto;
import com.emrekara.work3.app.user.entity.User;
import com.emrekara.work3.app.user.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;


    public List<UserDto> findAll() {

        List<User> userList = userEntityService.findAll();

        List<UserDto> userDtoList = UserMapper.INSTANCE.convertToUserDto(userList);

        return userDtoList;
    }
}
