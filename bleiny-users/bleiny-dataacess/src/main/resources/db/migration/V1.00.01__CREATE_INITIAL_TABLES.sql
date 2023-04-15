CREATE DATABASE IF NOT EXISTS spaces;

CREATE TABLE IF NOT EXISTS users_table(
    id bigint(20) auto_increment primary key,
    uuid varchar(150) unique not null,
    username varchar(25) not null,
    email varchar(255) unique not null,
    password varchar(255) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    image varchar(255) default null,
    is_active tinyint(2) not null,
    gender ENUM("MAN", "WOMAN", "UNDEFINED")
);

CREATE TABLE IF NOT EXISTS address_table(
    id bigint(20) auto_increment primary key,
    uf varchar(2) not null,
    city varchar(25) not null,
    country varchar(20) not null,
    address_uuid varchar(60) not null,
    user_id bigint(20) not null,
    foreign key(user_id) references users_table(id)
);

CREATE TABLE IF NOT EXISTS tellphone_table(
    id bigint(20) auto_increment primary key,
    tellphone_uuid varchar(60) not null,
    ddd varchar(3) not null,
    tellphone_number varchar(11) not null,
    country_code varchar(10) not null,
    user_id bigint(20) not null,
    foreign key(user_id) references users_table(id)
);

CREATE TABLE IF NOT EXISTS geoloc_table(
    id bigint(20) auto_increment primary key,
    geoloc_uuid varchar(60) not null,
    max_distance int not null,
    location_latitude DECIMAL(10,8),
    location_longitude DECIMAL(10,8),
    is_global tinyint(2),
    user_id bigint(20) not null,
    foreign key(user_id) references users_table(id)
);
