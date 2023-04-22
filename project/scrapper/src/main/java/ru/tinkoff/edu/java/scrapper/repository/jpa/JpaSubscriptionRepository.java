package ru.tinkoff.edu.java.scrapper.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tinkoff.edu.java.scrapper.entity.jpa.LinkEntity;
//import ru.tinkoff.edu.java.scrapper.entity.jpa.SubscriptionEntity;

import java.util.List;
import java.util.Optional;
//
//public interface JpaSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
//    //TODO дописать своё
////    void deleteByTgChatAndLink(TgChatEntity tgChat, LinkEntity link);
////
////    Optional<ChatLinkEntity> findByTgChatAndLink(TgChatEntity tgChat, LinkEntity link);
////
////    @Query("select cle.tgChat from ChatLinkEntity cle where cle.link.id=:id")
////    List<TgChatEntity> getTgChatsByLinkId(@Param("id") Long linkId);
//
//    @Query("select cle.link from SubscriptionEntity cle where cle.tgChat.id=:id")
//    List<LinkEntity> findLinksByChatId(@Param("id") Long tgChatId);
//}
