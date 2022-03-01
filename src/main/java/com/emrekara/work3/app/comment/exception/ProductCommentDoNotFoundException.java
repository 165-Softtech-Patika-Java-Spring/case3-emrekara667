package com.emrekara.work3.app.comment.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class ProductCommentDoNotFoundException extends RuntimeException{

    private final String name;

    public String getMessage(){
        return "Product: " + name + " HAVE NOT WRİTTEN any comments yet";
    }
}
