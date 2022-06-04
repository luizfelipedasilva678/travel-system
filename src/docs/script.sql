create database if not exists dbtravelsystem;
use dbtravelsystem; 

create table if not exists usuario (
    id int auto_increment,
    senha varchar(100) not null,
    login varchar(100) not null,
    role int default 1,
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 

create table if not exists pais (
    id int auto_increment,
    nome varchar(100),
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

create table if not exists local_visitado (
    id int auto_increment,
    imagem varchar(100) not null,
    nome varchar(100) not null,
    id_pais int not null,
    primary key(id),
    constraint foreign key(id_pais) references pais(id) on delete restrict on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

create table if not exists comentario (
    id int auto_increment,
    conteudo varchar(100),
    id_usuario int not null,
    primary key(id),
    constraint foreign key(id_usuario) references usuario(id) on delete restrict on update cascade	
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 

create table if not exists experiencia (
    id int auto_increment,
    conteudo varchar(100) not null,
    avalicao int default null,
    custo_total double not null,
    dia_de_chegada date not null,
    dia_de_partida date not null,
    id_local_visitado int not null,
    id_usuario int not null,
    primary key(id),
    constraint foreign key(id_local_visitado) references local_visitado(id) on delete restrict on update cascade,
    constraint foreign key(id_usuario) references usuario(id) on delete restrict on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 
