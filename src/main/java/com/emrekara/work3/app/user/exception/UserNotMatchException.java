package com.emrekara.work3.app.user.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class UserNotMatchException extends RuntimeException{

    private final String name;
    private final String phoneNumber;

    public String getMessage(){
        return "Username: "  + name + " and  phone number: " + phoneNumber + " information DO NOT MATCH";
    }
}
