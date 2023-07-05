# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Kiki\Documents\motobazar\motobazar.sql

drop database if exists motobazar;
create database motobazar;
use motobazar;

CREATE TABLE Korisnik (
    sifra INT PRIMARY KEY AUTO_INCREMENT,
    ime VARCHAR(50),
    prezime VARCHAR(50),
    adresa VARCHAR(100),
    email VARCHAR(100),
    lozinka VARCHAR(50)
);

CREATE TABLE Dio (
    sifra INT PRIMARY KEY AUTO_INCREMENT,
    naziv VARCHAR(100),
    proizvodac VARCHAR(50),
    cijena DECIMAL(10, 2),
    kolicina INT,
    opis TEXT,
    slika_url VARCHAR(255),
    korisnik_sifra INT,
    lokacija VARCHAR(100),
    telefon VARCHAR(20),
    datum_unosa DATE,
    FOREIGN KEY (korisnik_sifra) REFERENCES Korisnik(sifra)
);

CREATE TABLE Poruka (
    sifra INT PRIMARY KEY AUTO_INCREMENT,
    posiljatelj_sifra INT,
    primatelj_sifra INT,
    sadrzaj TEXT,
    datum_vrijeme DATETIME,
    FOREIGN KEY (posiljatelj_sifra) REFERENCES Korisnik(sifra),
    FOREIGN KEY (primatelj_sifra) REFERENCES Korisnik(sifra)
);

CREATE TABLE Ocjena (
    sifra INT PRIMARY KEY AUTO_INCREMENT,
    dio_sifra INT,
    korisnik_sifra INT,
    ocjena INT,
    FOREIGN KEY (dio_sifra) REFERENCES Dio(sifra),
    FOREIGN KEY (korisnik_sifra) REFERENCES Korisnik(sifra)
);


