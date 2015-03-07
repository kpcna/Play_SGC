# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cours (
  id                        varchar(255) not null,
  titre                     varchar(255),
  description               varchar(255),
  sigle                     varchar(255),
  credits                   integer,
  constraint pk_cours primary key (id))
;

create table person (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create sequence cours_seq;

create sequence person_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists cours;

drop table if exists person;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists cours_seq;

drop sequence if exists person_seq;

