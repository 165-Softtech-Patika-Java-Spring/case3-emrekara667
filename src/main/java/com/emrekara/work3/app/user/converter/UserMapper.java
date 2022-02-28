package com.emrekara.work3.app.user.converter;

import com.emrekara.work3.app.user.dto.UserDto;
import com.emrekara.work3.app.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> convertToUserDto(List<User> userList);
}
