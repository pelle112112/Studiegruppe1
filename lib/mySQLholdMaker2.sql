CREATE DATABASE IF NOT EXISTS Tournament DEFAULT CHARSET = utf8mb4;
use Tournament;

SET FOREIGN_KEY_CHECKS=0;
drop table if exists Team;
drop table if exists Player;
drop table if exists MMatch;
SET FOREIGN_KEY_CHECKS=1;

create table Team(
IDteam tinyint primary key auto_increment,
teamName varchar(100),
Player1 varchar(100),
Player2 varchar(100)
);

create table MMatch(
IDmatch tinyint primary key auto_increment,
teamName varchar(100),
Player1 varchar(100),
Player2 varchar(100)
);


create table Player(
id tinyint primary key auto_increment,
player_name varchar(20),
balance mediumint
);