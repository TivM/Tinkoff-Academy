package ru.tinkoff.edu.java.scrapper.controller;


import org.openapitools.api.TgChatApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TgChatController implements TgChatApi {

    @Override
    public ResponseEntity<Void> tgChatIdDelete(Long id) {
        return TgChatApi.super.tgChatIdDelete(id);
    }

    @Override
    public ResponseEntity<Void> tgChatIdPost(Long id) {
        return TgChatApi.super.tgChatIdPost(id);
    }
}
