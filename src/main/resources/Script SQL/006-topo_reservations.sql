create table topo_reservations
(
    topo_id         int not null,
    reservations_id int not null,
    constraint UK_j8u7c0hlkvgv9vjj6aal77yri
        unique (reservations_id)
) engine=MyISAM;

create index FK4qw29bc4nuteb0qj9irl5yugy
    on topo_reservations (topo_id);

