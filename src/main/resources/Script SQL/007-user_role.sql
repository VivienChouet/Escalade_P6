create table user_role
(
    user_id int not null,
    role_id int not null
);

create index FKj345gk1bovqvfame88rcx7yyx
    on user_role (user_id);

create index FKt7e7djp752sqn6w22i6ocqy6q
    on user_role (role_id);

