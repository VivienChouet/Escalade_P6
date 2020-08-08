create table topo
(
    id            int          not null
        primary key,
    available     bit          null,
    created_at    datetime     null,
    description   varchar(255) not null,
    lieux         varchar(255) not null,
    name          varchar(255) not null,
    official_topo bit          null,
    statut_public bit          null,
    update_at     datetime     null,
    users_id      int          null
) engine=MyISAM;

create index FK5whvuea6uqtfcr6a0q6vtcy6c
    on topo (users_id);

