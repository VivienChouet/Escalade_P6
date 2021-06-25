create table reservation
(
    id                   int          not null
        primary key,
    accepted_reservation bit          null,
    close_reservation    bit          null,
    created_at           datetime     null,
    reservation_status   varchar(255) null,
    update_at            datetime     null,
    topo_id              int          null,
    users_id             int          null
) ;

create index FK15w8lrbqikmtjwas4jalyrawq
    on reservation (users_id);

create index FKs6rhp8bjbn9p9imq1k5fcpb6a
    on reservation (topo_id);

