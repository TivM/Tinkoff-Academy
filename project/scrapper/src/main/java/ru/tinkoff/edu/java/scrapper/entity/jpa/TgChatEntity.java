package ru.tinkoff.edu.java.scrapper.entity.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "tg_chat")
public class TgChatEntity {

    @Id
    @Column(name = "ig")
    private Long id;

    @Column(name = "crated_at")
    private OffsetDateTime createdAt;
}
