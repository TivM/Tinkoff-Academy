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
        ApiErrorResponse response = ApiErrorResponse.builder()
                .description("Incorrect JSON")
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .exceptionName(ex.getClass().getName())
                .exceptionMessage(ex.getMessage())
                .stacktrace(ex.getStackTrace())
                .build();
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler({IncorrectRequestParameterException.class,})
    public ResponseEntity<Object> handleIncorrectRequestParameterException(IncorrectRequestParameterException ex) {
        ApiErrorResponse response = ApiErrorResponse.builder()
                .description("Incorrect request parameter")
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .exceptionName(ex.getClass().getName())
                .exceptionMessage(ex.getMessage())
                .stacktrace(ex.getStackTrace())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


//    private ResponseEntity<Object> createError(String description, Exception exception, String code) {
//        ApiErrorResponse response = new ApiErrorResponse();
//        response.setDescription(description);
//        response.setCode(code);
//        response.setExceptionName(exception.getClass().getName());
//        response.setExceptionMessage(exception.getMessage());
//        exception.setStackTrace(exception.getStackTrace());
//
//    }
}
