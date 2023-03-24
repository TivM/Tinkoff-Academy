package ru.tinkoff.edu.java.scrapper.controller.exceptionhandler;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.openapitools.model.ApiErrorResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tinkoff.edu.java.scrapper.exception.IncorrectRequestParameterException;

import java.util.Map;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleHttpMessageNotReadable(IncorrectRequestParameterException ex) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setDescription("Incorrect request parameters");
        response.setCode(String.valueOf(HttpStatus.BAD_REQUEST));
        response.setExceptionName(ex.getClass().getName());
        response.exceptionMessage(ex.getMessage());
        response.setStacktrace(ex.getStackTrace());


        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler({MethodArgumentTypeMismatchException.class,})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        ApiErrorResponse response = new ApiErrorResponse();

        response.setDescription("Incorrect argument");
        response.setCode(String.valueOf(HttpStatus.BAD_REQUEST));
        response.setExceptionName(e.getClass().getName());
        response.exceptionMessage(e.getMessage());
        response.setStacktrace(e.getStackTrace());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }




}
