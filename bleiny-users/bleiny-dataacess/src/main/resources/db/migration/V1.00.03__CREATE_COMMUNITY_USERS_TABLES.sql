CREATE TABLE IF NOT EXISTS tb_server_member(
    id bigint(20) auto_increment primary key,
    id_community bigint(20) not null,
    id_user bigint(20) not null,

    foreign key (id_user) references users_table(id),
    foreign key (id_community) references community_table(id)
)