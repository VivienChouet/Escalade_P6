create table comment
(
    id         int          not null
        primary key,
    content    varchar(255) not null,
    created_at datetime     null,
    site_id    int          null,
    users_id   int          null
) engine=MyISAM;

create index FK6jl05pq36bj9wvqvsoq3xbncg
    on comment (site_id);

create index FKmea7pyuw3c1i7w8y0wljw1sy7
    on comment (users_id);

