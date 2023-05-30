package ru.tinkoff.edu.java.bot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.request.SetMyCommands;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.processor.BotUpdatesDispatcher;
import ru.tinkoff.edu.java.bot.processor.CommandProcessor;

@Configuration
@RequiredArgsConstructor
public class BotConfig {
    private final ApplicationConfig applicationConfig;

    private final MeterRegistry meterRegistry;

    @Bean
    TelegramBot telegramBot(CommandProcessor commandProcessor) {
        TelegramBot bot = new TelegramBot(applicationConfig.bot().apiKey());

        BotUpdatesDispatcher botUpdatesDispatcher = new BotUpdatesDispatcher(bot, commandProcessor, meterRegistry);
        bot.setUpdatesListener(botUpdatesDispatcher);

        bot.execute(new SetMyCommands(botUpdatesDispatcher.getCommands().toArray(new BotCommand[0])));

        return bot;
    }
}
