package ru.tinkoff.edu.java.scrapper.client.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tinkoff.edu.java.scrapper.client.dto.StackOverflowApiResponse;
import ru.tinkoff.edu.java.scrapper.client.dto.StackOverflowItemApiResponse;

public interface StackOverflowClient {
    StackOverflowApiResponse fetchQuestion(String id);
}
