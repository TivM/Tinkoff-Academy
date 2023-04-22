package ru.tinkoff.edu.java.scrapper.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.edu.java.scrapper.entity.jpa.LinkEntity;

import java.util.Optional;

public interface JpaLinkRepository extends JpaRepository<LinkEntity, Long> {


}
