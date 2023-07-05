# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Kiki\Documents\motobazar\motobazar.sql

drop database if exists motobazar;
create database motobazar;
use motobazar;

create table dio(
    sifra int not null primary key auto_increment,
    naziv varchar(100),
    opis varchar(100),
    proizvodac varchar(50),
    cijena decimal(10,2),
    kolicina int,
    datum_unosa date
);