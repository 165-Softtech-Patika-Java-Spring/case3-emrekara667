package com.emrekara.work3.app.gen.exceptions;

import com.emrekara.work3.app.gen.enums.BaseErrorMessage;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.prefs.BackingStoreException;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
@Data
public class GenBusinessException extends RuntimeException{

    private final BaseErrorMessage baseErrorMessage;


}
