create table users
(
    id         int          not null
        primary key,
    created_at datetime     null,
    email      varchar(255) not null,
    name       varchar(255) not null,
    password   varchar(255) not null,
    update_at  datetime     null
) engine=MyISAM;

