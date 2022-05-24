create database if not exists dbtravelsystem;
use dbhospital; 

create table if not exists usuario (
	id int auto_increment,
    senha varchar(100) not null,
    login varchar(100) not null,
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 

create table if not exists pais (
	id int auto_increment,
	nome varchar(100),
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

create table if not exists local_visitado(
	id int auto_increment,
    imagem varchar(100) not null,
    id_pais int not null,
    primary key(id),
    foreign key(id_pais) references pais(id) on delete restrict on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

create table if not exists viajem (
	id int auto_increment,
    custo float,
    seguranca varchar(100),
    formas_de_viajem varchar(100),
    id_local_visitado int not null,
    outras_informacoes varchar(100),
    id_usuario int not null,
    primary key(id),
    foreign key(id_local_visitado) references local_visitado(id) on delete restrict on update cascade,
    foreign key(id_usuario) references usuario(id)  on delete restrict on update cascade
);

create table if not exists experiencia (
    id int auto_increment,
    conteudo varchar(100),
    avalicao int default null,
    id_local_visitado int not null,
    id_usuario int not null,
    primary key(id),
    constraint foreign key(id_local_visitado ) references local_visitado(id) on delete restrict on update cascade,
    foreign key(id_usuario) references usuario(id) on delete restrict on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 
