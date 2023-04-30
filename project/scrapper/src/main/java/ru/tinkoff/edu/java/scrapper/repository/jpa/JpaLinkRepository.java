package ru.tinkoff.edu.java.scrapper.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tinkoff.edu.java.scrapper.entity.Link;
import ru.tinkoff.edu.java.scrapper.entity.TgChat;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface JpaLinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findByUrl(String url);

    @Modifying
    @Query("update Link l set l.lastCheckTime = :lastCheckTime, l.updatedAt = :updatedAt,\n" +
            "            l.updatesCount = :updatesCount where l.id = :id")
    void update(OffsetDateTime lastCheckTime,
                OffsetDateTime updatedAt,
                Integer updatesCount,
                Long id);

    @Query(value = "select * from link order by last_check_time nulls first limit :limit", nativeQuery = true)
    List<Link> findCheckedLongTimeAgoLinks(@Param("limit") int limit);

    @Query(value = "select id, created_at from tg_chat c join subscription cl on c.id = cl.tg_chat_id\n" +
            "            where cl.link_id = :id", nativeQuery = true)
    List<TgChat> findChatsByLinkId(@Param("id") Long id);


}
