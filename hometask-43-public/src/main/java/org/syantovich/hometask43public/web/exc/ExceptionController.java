package org.syantovich.hometask43public.web.exc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.syantovich.hometask43public.dto.ErrorDto;
import org.syantovich.hometask43public.exc.CommonException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDto> exception(CommonException e) {
        ErrorDto errorDto = new ErrorDto(e.getMsg(), e.getCode());
        return ResponseEntity.badRequest().body(errorDto);
    }
}
