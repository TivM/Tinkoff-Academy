package ru.tinkoff.edu.java.bot.client.exception;

import org.openapitools.model.ApiErrorResponse;

public class ApiClientErrorException extends RuntimeException{

    private final ApiErrorResponse apiErrorResponse;

    public ApiClientErrorException(ApiErrorResponse apiErrorResponse) {
        super("Incorrect request for Scrapper");
        this.apiErrorResponse = apiErrorResponse;
    }

    public ApiErrorResponse getApiErrorResponse() {
        return apiErrorResponse;
    }
}
