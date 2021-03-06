# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cours (
  sigle                     varchar(255) not null,
  titre                     varchar(255),
  description               varchar(255),
  credits                   integer,
  sigle_prealable           varchar(255),
  constraint pk_cours primary key (sigle))
;

create table horaire (
  id                        bigint auto_increment not null,
  journee                   varchar(255),
  datedebut                 varchar(255),
  datefin                   varchar(255),
  heuredebut                varchar(255),
  heurefin                  varchar(255),
  courssigle                varchar(255),
  constraint pk_horaire primary key (id))
;

create table person (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  user_type                 integer,
  user_type_str             varchar(255),
  constraint pk_user primary key (email))
;


create table coursinscrits (
  user_email                     varchar(255) not null,
  cours_sigle                    varchar(255) not null,
  constraint pk_coursinscrits primary key (user_email, cours_sigle))
;



alter table coursinscrits add constraint fk_coursinscrits_user_01 foreign key (user_email) references user (email) on delete restrict on update restrict;

alter table coursinscrits add constraint fk_coursinscrits_cours_02 foreign key (cours_sigle) references cours (sigle) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table cours;

drop table horaire;

drop table person;

drop table user;

drop table coursinscrits;

SET FOREIGN_KEY_CHECKS=1;

