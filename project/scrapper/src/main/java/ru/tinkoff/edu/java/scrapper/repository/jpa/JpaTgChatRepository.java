package ru.tinkoff.edu.java.scrapper.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.edu.java.scrapper.entity.jpa.TgChatEntity;

public interface JpaTgChatRepository extends JpaRepository<TgChatEntity, Long> {
}
