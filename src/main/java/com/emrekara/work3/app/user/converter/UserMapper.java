package com.emrekara.work3.app.user.converter;

import com.emrekara.work3.app.user.dto.UserDeleteDto;
import com.emrekara.work3.app.user.dto.UserDto;
import com.emrekara.work3.app.user.dto.UserSaveRequestDto;
import com.emrekara.work3.app.user.dto.UserUpdateRequestDto;
import com.emrekara.work3.app.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> convertToUserDtoList(List<User> userList);

    User convertToUser(UserSaveRequestDto userSaveRequestDto);

    UserDto convertToUserDto(User user);

    User convertToUser(UserUpdateRequestDto userUpdateRequestDto);

    User covertToUser(UserDeleteDto userDeleteDto);
}
