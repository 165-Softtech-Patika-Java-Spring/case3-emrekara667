package com.emrekara.work3.app.user.dto;

import com.emrekara.work3.app.user.enums.UserType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserSaveRequestDto {

    private String email;
    private String name;
    private String telephoneNumber;
    private UserType userType;
}
