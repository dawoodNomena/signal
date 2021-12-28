
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

CREATE SEQUENCE admin_seq;
CREATE TABLE admin (
    id int NOT NULL DEFAULT nextval('admin_seq'),
    login varchar(100),
    nom varchar(100),
    mdp varchar(255)
);
ALTER SEQUENCE admin_seq OWNED BY admin.id;
ALTER TABLE admin ADD PRIMARY KEY (id);

CREATE SEQUENCE region_seq;
CREATE TABLE region (
    id int NOT NULL DEFAULT nextval('region_seq'),
    nom varchar(100),
    coorX double precision,
    coorY double precision
);
ALTER SEQUENCE region_seq OWNED BY region.id;
ALTER TABLE region ADD PRIMARY KEY (id);

CREATE SEQUENCE responsable_seq;
CREATE TABLE responsable (
    id int NOT NULL DEFAULT nextval('responsable_seq'),
    login varchar(100),
    nom varchar(100),
    idRegion int NOT NULL,
    mdp varchar(255)
);
ALTER SEQUENCE responsable_seq OWNED BY responsable.id;
ALTER TABLE responsable ADD PRIMARY KEY (id);
ALTER TABLE responsable
ADD CONSTRAINT responsable_fk
FOREIGN KEY (idRegion)
REFERENCES region(id)
ON DELETE CASCADE;

CREATE SEQUENCE typeSignalement_seq;
CREATE TABLE typeSignalement (
    id int NOT NULL DEFAULT nextval('typeSignalement_seq'),
     titre varchar(100),
    description varchar(255)
);
ALTER SEQUENCE typeSignalement_seq OWNED BY typeSignalement.id;
ALTER TABLE typeSignalement ADD PRIMARY KEY (id);

CREATE SEQUENCE user_seq;
CREATE TABLE user (
    id int NOT NULL ,
    login varchar(100),
    nom varchar(100),
    mdp varchar(255)
);
ALTER SEQUENCE user_seq OWNED BY user.id;
ALTER TABLE user ADD PRIMARY KEY (id);

CREATE SEQUENCE signalement_seq;
CREATE TABLE signalement (
    id int NOT NULL DEFAULT nextval('signalement_seq'),
    idRegion int NOt NULL,
    idUser int NOT NULL,
    date datetime,
    idType int,
    status varchar(100),
    coorX double precision,
    coorY double precision
);
ALTER SEQUENCE signalement_seq OWNED BY signalement.id;
ALTER TABLE signalement ADD PRIMARY KEY (id);
ALTER TABLE signalement ADD CONSTRAINT region_fk FOREIGN KEY (idRegion) REFERENCES region(id) ON DELETE CASCADE;
ALTER TABLE signalement ADD CONSTRAINT user_fk FOREIGN KEY (idUser) REFERENCES user(id) ON DELETE CASCADE;
ALTER TABLE signalement ADD CONSTRAINT type_fk FOREIGN KEY (idType) REFERENCES typeSignalement(id) ON DELETE CASCADE;

insert into region(nom, coorX, coorY) values('Analamanga', 10.22222, 28.210215648);
insert into region(nom, coorX, coorY) values('Sofia', 12.2222, 24.210215648);
insert into region(nom, coorX, coorY) values('Diana', 15.22222, 28.210215648);
insert into region(nom, coorX, coorY) values('Boeny', 20.22222, 28.210215648);

