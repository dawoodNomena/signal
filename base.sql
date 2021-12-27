create database signalement;
use signalement;
create table admin(
    id int primary key AUTO_INCREMENT,
    login varchar(100),
    nom varchar(100),
    mdp varchar(255)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

create table region(
    id int primary key AUTO_INCREMENT,
    nom varchar(100),
    coorX double,
    coorY double
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

create table responsable(
    id int primary key AUTO_INCREMENT,
    login varchar(100),
    nom varchar(100),
    idRegion int,
    mdp varchar(255),
    foreign key (idRegion) references region(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

create table typeSignalement(
    id int primary key AUTO_INCREMENT,
    titre varchar(100),
    description varchar(255)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

create table user(
    id int primary key AUTO_INCREMENT,
    login varchar(100),
    nom varchar(100),
    mdp varchar(255)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

create table signalement(
    id int primary key AUTO_INCREMENT
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
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

insert into region(nom, coorX, coorY) values('Analamanga', 10.22222, 28.210215648);
insert into region(nom, coorX, coorY) values('Sofia', 12.2222, 24.210215648);
insert into region(nom, coorX, coorY) values('Diana', 15.22222, 28.210215648);
insert into region(nom, coorX, coorY) values('Boeny', 20.22222, 28.210215648);