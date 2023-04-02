package ru.tinkoff.edu.java.bot.client.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.bot.client.api.ScrapperClient;
import ru.tinkoff.edu.java.bot.dto.LinkResponse;
import ru.tinkoff.edu.java.bot.dto.ListLinksResponse;

//TODO: доделать реализацию методов
public class ScrapperWebClient implements ScrapperClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static final String SLASH = "/";

    //private final WebClient webClient;
    private final String baseUrl;
    private final WebClient webClient;

    public ScrapperWebClient(WebClient webClient) {
        this.webClient = webClient;
        baseUrl = BASE_URL;
    }

    public ScrapperWebClient(String baseUrl, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }

    @Override
    public ResponseEntity<LinkResponse> linksDelete(Long tgChatId, String url) {
        return null;
    }

    @Override
    public ResponseEntity<ListLinksResponse> linksGet(Long tgChatId) {
        return null;
    }

    @Override
    public ResponseEntity<LinkResponse> linksPost(Long tgChatId, String url) {
        return null;
    }

    @Override
    public ResponseEntity<Void> tgChatIdDelete(Long tgChatId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> tgChatIdPost(Long tgChatId) {
        return null;
    }
}
