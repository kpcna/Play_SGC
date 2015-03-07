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




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table cours;

drop table person;

SET FOREIGN_KEY_CHECKS=1;

