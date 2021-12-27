create database signalement;
use signalement;
create table admin(
    id int primary key,
    login varchar(100),
    nom varchar(100),
    mdp varchar(255)
);

create table region(
    id int primary key,
    nom varchar(100),
    coorX double,
    coorY double
);

create table responsable(
    id int primary key,
    login varchar(100),
    nom varchar(100),
    idRegion int,
    mdp varchar(255),
    foreign key (idRegion) references region(id)
);

create table typeSignalement(
    id int primary key,
    titre varchar(100),
    description varchar(255)
);

create table user(
    id int primary key,
    login varchar(100),
    nom varchar(100),
    mdp varchar(255)
);

create table signalement(
    id int primary key,
    idRegion int,
    idUser int,
    date datetime,
    idType int,
    status varchar(100),
    coorX double,
    coorY double,
    foreign key (idRegion) references region(id),
    foreign key (idUser) references user(id),
    foreign key (idType) references type(id)
);