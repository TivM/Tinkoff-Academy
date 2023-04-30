package ru.tinkoff.edu.java.bot.service.receiver;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import org.openapitools.model.LinkUpdateRequest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import ru.tinkoff.edu.java.bot.processor.message.MessageSender;

@RabbitListener(queues = "${app.queue-name}")
public class QueueUpdatesReceiver extends UpdatesReceiver{

    public QueueUpdatesReceiver(TelegramBot telegramBot, MessageSender messageSender) {
        super(telegramBot, messageSender);
    }

    @RabbitHandler
    @Override
    public void receiveUpdates(LinkUpdateRequest linkUpdateRequest) {
        this.alertUpdates(linkUpdateRequest);
    }

    @RabbitListener(queues = "${app.queue-name}.dlq")
    public void processFailedMessagesRequeue(Message failedMessage) {
        System.out.println("Error while receiving update: " + failedMessage);
    }
}
