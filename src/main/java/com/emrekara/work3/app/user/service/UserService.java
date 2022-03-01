package com.emrekara.work3.app.user.service;

import com.emrekara.work3.app.gen.enums.GenErrorMessage;
import com.emrekara.work3.app.gen.exceptions.ItemNotFoundException;
import com.emrekara.work3.app.user.converter.UserMapper;
import com.emrekara.work3.app.user.dto.UserDeleteDto;
import com.emrekara.work3.app.user.dto.UserDto;
import com.emrekara.work3.app.user.dto.UserSaveRequestDto;
import com.emrekara.work3.app.user.dto.UserUpdateRequestDto;
import com.emrekara.work3.app.user.entity.User;
import com.emrekara.work3.app.user.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;


    public List<UserDto> findAll() {

        List<User> userList = userEntityService.findAll();

        List<UserDto> userDtoList = UserMapper.INSTANCE.convertToUserDtoList(userList);

        return userDtoList;
    }

    public UserDto save(UserSaveRequestDto userSaveRequestDto) {

        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);

        Optional<User> userOptional = userEntityService.getDao().findByEmailOrNameOrTelephoneNumber(user.getName(),
                user.getEmail(),user.getTelephoneNumber());

        if(userOptional.isPresent()){
            throw new ItemNotFoundException(GenErrorMessage.FILE_ALREADY_EXIST);
        }


        user = userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    public UserDto findById(Long id) {

        User user = userEntityService.getByIdWithControl(id);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    public UserDto findByName(String name) {
        User user = userEntityService.getByName(name);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    public UserDto update(UserUpdateRequestDto userUpdateRequestDto) {
        controlIsCustomerExist(userUpdateRequestDto);

        User user;
        user = UserMapper.INSTANCE.convertToUser(userUpdateRequestDto);

        userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    private void controlIsCustomerExist(UserUpdateRequestDto userUpdateRequestDto){
        Long id = userUpdateRequestDto.getId();
        boolean isExist = userEntityService.existsById(id);
        if(!isExist){
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
        }
    }

    public void delete(UserDeleteDto userDeleteDto) {

        User user = UserMapper.INSTANCE.covertToUser(userDeleteDto);

        user = userEntityService.getByNameAndPhoneWithControl(user);

        userEntityService.delete(user);
    }
}
