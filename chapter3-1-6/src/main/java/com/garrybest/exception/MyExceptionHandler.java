package com.garrybest.exception;

import com.garrybest.dto.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo<String> errorFound(HttpServletRequest req, MyException e) {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setMessage(e.getMessage());
        info.setCode(ErrorInfo.ERROR);
        info.setData("foo");
        info.setUrl(req.getRequestURL().toString());
        return info;
    }
}
