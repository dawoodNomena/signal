
psql postgres postgres 
CREATE DATABASE signalement
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'French_France.1252'
       LC_CTYPE = 'French_France.1252'
       CONNECTION LIMIT = -1;
alter database signalement owner to postgres

psql signalement postgres

CREATE SEQUENCE admin_seq start with 1 increment by 1;
CREATE TABLE admin (
    id bigint NOT NULL DEFAULT nextval('admin_seq'),
    login varchar(100),
    nom varchar(100),
    mdp varchar(255),
    PRIMARY KEY(id)
);
ALTER SEQUENCE admin_seq OWNED BY admin.id;

CREATE SEQUENCE region_seq start with 1 increment by 1;
CREATE TABLE region (
    id bigint NOT NULL DEFAULT nextval('region_seq'),
    nom varchar(100),
    coorX double precision,
    coorY double precision,
    PRIMARY KEY(id)
);
ALTER SEQUENCE region_seq OWNED BY region.id;

CREATE SEQUENCE responsable_seq start with 1 increment by 1;
CREATE TABLE responsable (
    id bigint NOT NULL DEFAULT nextval('responsable_seq'),
    login varchar(100),
    nom varchar(100),
    idRegion bigint NOT NULL,
    mdp varchar(255),
    PRIMARY KEY(id),
    FOREIGN KEY(idRegion) references region(id) ON DELETE CASCADE
);
ALTER SEQUENCE responsable_seq OWNED BY responsable.id;

CREATE SEQUENCE typeSignalement_seq start with 1 increment by 1;
CREATE TABLE typeSignalement (
    id bigint NOT NULL DEFAULT nextval('typeSignalement_seq'),
     titre varchar(100),
    description varchar(255),
    PRIMARY KEY(id)
);
ALTER SEQUENCE typeSignalement_seq OWNED BY typeSignalement.id;

CREATE SEQUENCE utilisateur_seq start with 1 increment by 1;
CREATE TABLE utilisateur (
    id bigint NOT NULL ,
    login varchar(100),
    nom varchar(100),
    mdp varchar(255),
    PRIMARY KEY(id)
);
ALTER SEQUENCE utilisateur_seq OWNED BY utilisateur.id;

CREATE SEQUENCE signalement_seq start with 1 increment by 1;
CREATE TABLE signalement (
    id bigint NOT NULL DEFAULT nextval('signalement_seq'),
    idRegion bigint NOt NULL,
    idUtilisateur bigint NOT NULL,
    date timestamp,
    idType bigint,
    status varchar(100),
    coorX double precision,
    coorY double precision,
    PRIMARY KEY(id),
    FOREIGN KEY(idRegion) references region(id) ON DELETE CASCADE,
    FOREIGN KEY(idUtilisateur) references utilisateur(id) ON DELETE CASCADE,
    FOREIGN KEY(idType) references typeSignalement(id) ON DELETE CASCADE
);
ALTER SEQUENCE signalement_seq OWNED BY signalement.id;

insert into region(nom, coorX, coorY) values('Analamanga', 10.22222, 28.210215648);
insert into region(nom, coorX, coorY) values('Sofia', 12.2222, 24.210215648);
insert into region(nom, coorX, coorY) values('Diana', 15.22222, 28.210215648);
insert into region(nom, coorX, coorY) values('Boeny', 20.22222, 28.210215648);

