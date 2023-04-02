package ru.tinkoff.edu.java.bot.client.api;

import org.springframework.http.ResponseEntity;
import ru.tinkoff.edu.java.bot.dto.LinkResponse;
import ru.tinkoff.edu.java.bot.dto.ListLinksResponse;

public interface ScrapperClient {
    ResponseEntity<LinkResponse> linksDelete(Long tgChatId, String url);
    ResponseEntity<ListLinksResponse> linksGet(Long tgChatId);
    ResponseEntity<LinkResponse> linksPost(Long tgChatId, String url);
    ResponseEntity<Void> tgChatIdDelete(Long tgChatId);
    ResponseEntity<Void> tgChatIdPost(Long tgChatId);



}
