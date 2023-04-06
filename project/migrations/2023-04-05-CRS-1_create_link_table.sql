--liquibase formatted sql

--changeset v.trofimchenko:add-link-table
create table link (
        id              bigint generated always as identity,
        url             text                     not null,
        last_check_time timestamp with time zone not null,
        created_at      timestamp with time zone not null,
        created_by      text                     not null,

        primary key (id),
        unique (url)
);