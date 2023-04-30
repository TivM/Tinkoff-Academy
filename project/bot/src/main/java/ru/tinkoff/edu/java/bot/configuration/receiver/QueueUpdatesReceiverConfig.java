package ru.tinkoff.edu.java.bot.configuration.receiver;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.processor.message.MessageSender;
import ru.tinkoff.edu.java.bot.service.receiver.QueueUpdatesReceiver;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "use-queue", havingValue = "true")
public class QueueUpdatesReceiverConfig {

    @Bean
    public QueueUpdatesReceiver queueUpdatesReceiver(TelegramBot telegramBot, MessageSender messageSender){
        return new QueueUpdatesReceiver(telegramBot, messageSender);
    }
}