create table voie
(
	id         int          not null
		primary key,
	created_at datetime     null,
	difficulte varchar(255) null,
	longueur   int          not null,
	name       varchar(255) null,
	update_at  datetime     null,
	site_id    int          null
);

create index FKry0xp2k6722vmxdc95ilxrd9v
	on voie (site_id);

