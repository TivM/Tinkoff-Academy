--liquibase formatted sql

--changeset v.trofimchenko:add-link-table
create table if not exists link (
        id              bigint generated always as identity,
        url             text                     not null,
        last_check_time timestamp with time zone,
        updated_at      timestamp with time zone,

        primary key (id),
        unique (url)
);