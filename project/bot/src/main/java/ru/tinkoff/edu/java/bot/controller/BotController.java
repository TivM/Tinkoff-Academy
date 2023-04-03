package ru.tinkoff.edu.java.bot.controller;


import lombok.RequiredArgsConstructor;
import org.openapitools.api.UpdatesApi;
import org.openapitools.model.LinkUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.client.api.ScrapperClient;
import ru.tinkoff.edu.java.bot.dto.LinkResponse;


@RestController
@RequiredArgsConstructor
public class BotController implements UpdatesApi {

    private final ScrapperClient scrapperClient;

    @Override
    public ResponseEntity<Void> updatesPost(LinkUpdateRequest linkUpdateRequest) {
        return UpdatesApi.super.updatesPost(linkUpdateRequest);
    }

    @PostMapping("/post")
    public LinkResponse linkPost(){
        return scrapperClient.linksPost(1L, "https://github.com/");

    }

    @DeleteMapping("/delete")
    public Void deleteChat(){
        return scrapperClient.tgChatIdDelete(123L);
    }


}



