package ru.tinkoff.edu.java.bot.client.exception;

import org.openapitools.model.ApiErrorResponse;

public class ApiInternalServerErrorException extends RuntimeException{
    private final ApiErrorResponse apiErrorResponse;

    public ApiInternalServerErrorException(ApiErrorResponse apiErrorResponse) {
        this.apiErrorResponse = apiErrorResponse;
    }

    public ApiErrorResponse getApiErrorResponse() {
        return apiErrorResponse;
    }
}
