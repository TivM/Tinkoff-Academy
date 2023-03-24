package ru.tinkoff.edu.java.scrapper.exception;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class IncorrectRequestParameterException extends RuntimeException {

    public IncorrectRequestParameterException(String message) {
        super(message);
    }
}
