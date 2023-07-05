# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Kiki\Documents\motobazar\motobazar.sql

drop database if exists motobazar;
create database motobazar;
use motobazar;

CREATE TABLE Korisnik (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ime VARCHAR(50),
    prezime VARCHAR(50),
    adresa VARCHAR(100),
    email VARCHAR(100),
    lozinka VARCHAR(50)
);

CREATE TABLE Dio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    naziv VARCHAR(100),
    proizvodac VARCHAR(50),
    cijena DECIMAL(10, 2),
    kolicina INT,
    datum_unosa DATE,
    korisnik_id INT,
    FOREIGN KEY (korisnik_id) REFERENCES Korisnik(id)
);

CREATE TABLE Poruka (
    id INT PRIMARY KEY AUTO_INCREMENT,
    posiljatelj_id INT,
    primatelj_id INT,
    sadrzaj TEXT,
    datum_vrijeme DATETIME,
    FOREIGN KEY (posiljatelj_id) REFERENCES Korisnik(id),
    FOREIGN KEY (primatelj_id) REFERENCES Korisnik(id)
);

CREATE TABLE Ocjena (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dio_id INT,
    korisnik_id INT,
    ocjena INT,
    FOREIGN KEY (dio_id) REFERENCES Dio(id),
    FOREIGN KEY (korisnik_id) REFERENCES Korisnik(id)
);

