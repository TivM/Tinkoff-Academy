package ru.tinkoff.edu.java.scrapper.service.notifier;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.scrapper.client.api.BotClient;
import ru.tinkoff.edu.java.scrapper.client.dto.LinkUpdateRequest;
import ru.tinkoff.edu.java.scrapper.entity.Link;
import ru.tinkoff.edu.java.scrapper.entity.TgChat;

import java.net.URI;
import java.util.Collection;


@RequiredArgsConstructor
public class HttpBotNotifier implements BotNotifier{

    private final BotClient botClient;

    @Override
    public void notifyBot(Link link, String description, Collection<TgChat> tgChats) {
        botClient.updatesPost(
                new LinkUpdateRequest(
                        link.getId(),
                        link.getUrl(),
                        description,
                        tgChats.stream().map(TgChat::getId).toList()
                    )
        );
    }
}

