CREATE TABLE IF NOT EXISTS community_table(
    id bigint(20) auto_increment primary key,
    community_uuid varchar(150) not null,
    community_name varchar(150) not null,
    description varchar(300) not null,
    community_image varchar(400) default null,
    user_id bigint(20) not null,
    members_quantity int,
    foreign key (user_id) references users_table(id)
);

CREATE TABLE IF NOT EXISTS tag_table(
    id bigint(20) auto_increment primary key,
    tag_name varchar(50) not null
);

CREATE TABLE IF NOT EXISTS tag_server_table(
    id bigint(20) auto_increment primary key,
    community_id bigint(20) not null,
    tag_id bigint(20) not null,
    foreign key (community_id) references community_table(id),
    foreign key (tag_id) references tag_table(id)
);


CREATE TABLE IF NOT EXISTS room_table(
    id bigint(20) auto_increment primary key,
    room_uuid varchar(150) not null,
    room_name varchar(60) not null,
    community_id bigint(20) not null,
    is_voice tinyint(1) default 0,
    foreign key (community_id) references community_table(id)
);
