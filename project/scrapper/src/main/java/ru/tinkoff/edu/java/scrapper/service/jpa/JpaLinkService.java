package ru.tinkoff.edu.java.scrapper.service.jpa;

import ru.tinkoff.edu.java.scrapper.entity.Link;
import ru.tinkoff.edu.java.scrapper.service.LinkService;

import java.net.URI;
import java.util.Collection;

public class JpaLinkService implements LinkService {
    @Override
    public Link add(long tgChatId, URI url) {
        return null;
    }

    @Override
    public Link remove(long tgChatId, URI url) {
        return null;
    }

    @Override
    public Collection<Link> listAll(long tgChatId) {
        return null;
    }
}
