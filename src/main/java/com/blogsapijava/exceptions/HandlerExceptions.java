package com.blogsapijava.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex) {
        ExceptionDetails details = ExceptionDetails.builder()
                .title("Resource not found")
                .message(ex.getMessage())
                .timestamps(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDetails> handlerDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ExceptionDetails details = ExceptionDetails.builder()
                .title("DataIntegrityViolationException")
                .message(ex.getMostSpecificCause().getMessage())
                .timestamps(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        List<FieldMessage> fieldMessageList = errors.stream()
                .map(error -> {
                    FieldMessage fieldMessage = FieldMessage.builder().field(error.getField()).build();
                    fieldMessage.setMessage(error.getDefaultMessage());
                    return fieldMessage;
                }).collect(Collectors.toList());

        ExceptionDetails details = ExceptionDetails.builder()
                .title("Invalid values")
                .message("Some values are invalid")
                .fields(fieldMessageList)
                .timestamps(LocalDateTime.now())
                .status(status.value())
                .build();

        return new ResponseEntity<>(details, status);
    }

}
