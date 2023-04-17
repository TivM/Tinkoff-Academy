package ru.tinkoff.edu.java.scrapper.controller;


import org.openapitools.api.LinksApi;
import org.openapitools.model.AddLinkRequest;
import org.openapitools.model.LinkResponse;
import org.openapitools.model.ListLinksResponse;
import org.openapitools.model.RemoveLinkRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.scrapper.exception.IncorrectRequestParameterException;
import ru.tinkoff.edu.java.scrapper.exception.ResourceNotFoundException;

@RestController
public class LinkController implements LinksApi {


    @Override
    public ResponseEntity<LinkResponse> linksDelete(Long tgChatId, RemoveLinkRequest removeLinkRequest) {
        //return LinksApi.super.linksDelete(tgChatId, removeLinkRequest);
        throw new ResourceNotFoundException("not exists");
    }

    @Override
    public ResponseEntity<ListLinksResponse> linksGet(Long tgChatId) {
        //return LinksApi.super.linksGet(tgChatId);
        throw new IncorrectRequestParameterException("some message...");
    }

    @Override
    public ResponseEntity<LinkResponse> linksPost(Long tgChatId, AddLinkRequest addLinkRequest) {
        return ResponseEntity.ok(new LinkResponse());
    }

}
