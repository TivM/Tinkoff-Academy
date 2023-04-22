package ru.tinkoff.edu.java.scrapper.service.jpa;


import lombok.RequiredArgsConstructor;
import ru.tinkoff.edu.java.scrapper.repository.jpa.JpaTgChatRepository;
import ru.tinkoff.edu.java.scrapper.service.TgChatService;

@RequiredArgsConstructor
public class JpaTgChatService implements TgChatService {
    private final JpaTgChatRepository jpaTgChatRepository;

    @Override
    public void register(long tgChatId) {
        //TODO доделать запрос в репозитории
        //jpaTgChatRepository.
    }

    @Override
    public void unregister(long tgChatId) {
        jpaTgChatRepository.deleteById(tgChatId);

    }
}
