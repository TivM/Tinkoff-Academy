package ru.tinkoff.edu.java.bot.botprocessor;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BotUpdatesDispatcherTest {

    @Mock
    private TelegramBot bot;

    @Mock
    private CommandProcessor commandProcessor;

    @InjectMocks
    BotUpdatesDispatcher botUpdatesDispatcher;

    //TODO: доделать тест

    @Test
    void process__unexpectedCommand_returnSpecialMessage() {
        // given
        Update update = getUpdate();
        when(commandProcessor.process(update)).thenReturn(Optional.empty());

        // when
        botUpdatesDispatcher.process(List.of(update));



        //SendMessage message = sendMessageArgumentCaptor.getValue();
        //assertEquals(result, );


    }

    // TODO: more tests

    Update getUpdate(){
        //Update -> Message -> Chat -> Id
        Update update = new Update();
        Message message = new Message();
        Chat chat = new Chat();

        ReflectionTestUtils.setField(chat, "id", 123L);
        ReflectionTestUtils.setField(message, "chat", chat);
        ReflectionTestUtils.setField(message, "text", "/unexpected");
        ReflectionTestUtils.setField(update, "message", message);
        return update;
    }

}
