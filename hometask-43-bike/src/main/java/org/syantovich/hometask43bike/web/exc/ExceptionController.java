package org.syantovich.hometask43bike.web.exc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.syantovich.hometask43bike.dto.ErrorDto;
import org.syantovich.hometask43bike.exc.CommonException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDto> exception(CommonException e) {
        ErrorDto errorDto = new ErrorDto(e.getMsg(), e.getCode());
        return ResponseEntity.badRequest().body(errorDto);
    }
}
