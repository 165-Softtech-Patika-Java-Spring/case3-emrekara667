package com.emrekara.work3.app.user.controller;

import com.emrekara.work3.app.user.dto.UserDto;
import com.emrekara.work3.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity getAll(){
        List<UserDto> userDtoList = userService.findAll();

        return ResponseEntity.ok(userDtoList);
    }





}
