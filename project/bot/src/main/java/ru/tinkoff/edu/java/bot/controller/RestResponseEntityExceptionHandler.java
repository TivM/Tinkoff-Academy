package ru.tinkoff.edu.java.bot.controller;


import org.openapitools.model.ApiErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tinkoff.edu.java.bot.exception.IncorrectRequestParameterException;


@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

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

    @ExceptionHandler({IncorrectRequestParameterException.class,})
    public ResponseEntity<Object> handleIncorrectRequestParameterException(IncorrectRequestParameterException ex) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setDescription("Incorrect request parameter");
        response.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        response.setExceptionName(ex.getClass().getName());
        response.exceptionMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
