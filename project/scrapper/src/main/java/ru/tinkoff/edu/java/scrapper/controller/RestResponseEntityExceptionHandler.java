package ru.tinkoff.edu.java.scrapper.controller;


import org.openapitools.model.ApiErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tinkoff.edu.java.scrapper.exception.IncorrectRequestParameterException;
import ru.tinkoff.edu.java.scrapper.exception.ResourceNotFoundException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setDescription("Incorrect request body");
        response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setExceptionName(ex.getClass().getName());
        response.exceptionMessage(ex.getMessage());
        response.setStacktrace(ex.getStackTrace());
        return new ResponseEntity<>(response, status);
    }


    @ExceptionHandler({MethodArgumentTypeMismatchException.class,})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setDescription("Incorrect argument");
        response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setExceptionName(ex.getClass().getName());
        response.exceptionMessage(ex.getMessage());
        response.setStacktrace(ex.getStackTrace());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IncorrectRequestParameterException.class,})
    public ResponseEntity<Object> handleIncorrectRequestParameterException(IncorrectRequestParameterException ex) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setDescription("Incorrect request parameter");
        response.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        response.setExceptionName(ex.getClass().getName());
        response.exceptionMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ResourceNotFoundException.class,})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setDescription("Not found");
        response.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        response.setExceptionName(ex.getClass().getName());
        response.exceptionMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }






}