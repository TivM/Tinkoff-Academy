--liquibase formatted sql

--changeset v.trofimchenko:add-tg_chat-table
create table tg_chat (
    id              bigint generated always as identity,
    created_at      timestamp with time zone    not null,
    created_by      text                        not null,

    primary key (id)
);