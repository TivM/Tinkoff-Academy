package ru.tinkoff.edu.java.scrapper.entity.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.time.OffsetDateTime;

@Getter
@Setter
@Table(name = "link")
@Entity
public class LinkEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private URI url;

    @Column(name = "last_check_time")
    private OffsetDateTime lastCheckTime;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "updates_count")
    private Integer updatesCount;
}
