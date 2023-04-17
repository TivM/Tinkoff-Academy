package ru.tinkoff.edu.java.scrapper.scheduler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.scrapper.service.updater.LinksUpdater;

@Slf4j
@Component
@RequiredArgsConstructor
public class LinkUpdaterScheduler {
    private final LinksUpdater linksUpdater;

    //TODO: add limit in application.yml
    @Value("${app.scheduler.limit}")
    private Integer updateLinkLimit;

    @Scheduled(fixedDelayString = "#{@schedulerIntervalMs}")
    public void update() {
        linksUpdater.updateLinks(2);
        //linksUpdater.updateLinks(updateLinkLimit); //TODO: check this
        log.info("Update method in LinkUpdaterScheduler class");

    }
}
