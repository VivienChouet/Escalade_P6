create table site
(
    id         int          not null
        primary key,
    adresse    varchar(255) null,
    contact    varchar(255) null,
    created_at datetime     null,
    name       varchar(255) null,
    update_at  datetime     null,
    topo_id    int          null,
    users_id   int          null
) engine=MyISAM;

create index FK8mkfxlm6kvmhhmwnabf6h4gp9
    on site (users_id);

create index FKowfn7flv042yuklx2avx022iu
    on site (topo_id);

