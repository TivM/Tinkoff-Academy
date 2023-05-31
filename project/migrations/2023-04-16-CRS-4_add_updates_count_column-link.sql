--liquibase formatted sql

--changeset v.trofimchenko:add-updates_count_column-link
alter table link add updates_count int;