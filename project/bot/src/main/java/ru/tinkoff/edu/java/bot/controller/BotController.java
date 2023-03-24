package ru.tinkoff.edu.java.bot.controller;


import org.openapitools.api.UpdatesApi;
import org.openapitools.model.LinkUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BotController implements UpdatesApi {
    @Override
    public ResponseEntity<Void> updatesPost(LinkUpdateRequest linkUpdateRequest) {
        return UpdatesApi.super.updatesPost(linkUpdateRequest);
    }

}



