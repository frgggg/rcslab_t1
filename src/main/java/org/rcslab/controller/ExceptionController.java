package org.rcslab.controller;

import org.rcslab.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<String> methodArgumentNotValidExceptionHandler(MissingServletRequestParameterException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<String> serviceExceptionHandler(ServiceException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), BAD_REQUEST);
    }
}
