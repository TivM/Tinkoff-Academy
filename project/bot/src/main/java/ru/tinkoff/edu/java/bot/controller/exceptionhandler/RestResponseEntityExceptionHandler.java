package ru.tinkoff.edu.java.bot.controller.exceptionhandler;


import org.openapitools.model.ApiErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

    //Спросить насчет добавления своих эксепшенов
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setDescription("Incorrect JSON");
        response.setCode(String.valueOf(HttpStatus.BAD_REQUEST));
        response.setExceptionName(ex.getClass().getName());
        response.exceptionMessage(ex.getMessage());
        response.setStacktrace(ex.getStackTrace());

        return new ResponseEntity<>(response, status);
    }
}
