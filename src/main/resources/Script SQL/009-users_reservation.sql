create table users_reservation
(
    users_id       int not null,
    reservation_id int not null,
    constraint UK_3r17iloipbipufkr6nrvemhb2
        unique (reservation_id)
) engine=MyISAM;

create index FKnqmvi63m41wyh89d4xkio7gy0
    on users_reservation (users_id);

