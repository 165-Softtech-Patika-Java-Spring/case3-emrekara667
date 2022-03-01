package com.emrekara.work3.app.user.controller;

import com.emrekara.work3.app.user.dto.UserDeleteDto;
import com.emrekara.work3.app.user.dto.UserDto;
import com.emrekara.work3.app.user.dto.UserSaveRequestDto;
import com.emrekara.work3.app.user.dto.UserUpdateRequestDto;
import com.emrekara.work3.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity save(@RequestBody UserSaveRequestDto userSaveRequestDto){

        UserDto userDto = userService.save(userSaveRequestDto);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        UserDto userDto = userService.findById(id);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        UserDto userDto = userService.findByName(name);

        return ResponseEntity.ok(userDto);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserUpdateRequestDto userUpdateRequestDto){

        UserDto userDto = userService.update(userUpdateRequestDto);

        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestBody UserDeleteDto userDeleteDto){
        userService.delete(userDeleteDto);

        return ResponseEntity.ok(Void.TYPE);
    }









}
