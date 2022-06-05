create database if not exists dbtravelsystem;
use dbtravelsystem; 

create table if not exists user (
    id int auto_increment,
    password varchar(100) not null,
    login varchar(100) not null,
    role int default 1,
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 

create table if not exists country (
    id int auto_increment,
    name varchar(100),
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

create table if not exists place_visited (
    id int auto_increment,
    image varchar(100) not null,
    name varchar(100) not null,
    id_country int not null,
    primary key(id),
    constraint foreign key(id_country) references country(id) on delete restrict on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;


create table if not exists experience (
    id int auto_increment,
    content varchar(100) not null,
    rating int default null,
    total_cost double not null,
    arrival_day date not null,
    departure_day date not null,
    id_place_visited int not null,
    id_user int not null,
    primary key(id),
    constraint foreign key(id_place_visited) references place_visited(id) on delete restrict on update cascade,
    constraint foreign key(id_user) references user(id) on delete restrict on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 

create table if not exists comment (
    id int auto_increment,
    content varchar(100),
    id_user int not null,
    id_experience int not null,
    primary key(id),
    constraint foreign key(id_user) references user(id) on delete restrict on update cascade,
    constraint foreign key(id_experience) references experience(id) on delete restrict on update cascade	
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 
