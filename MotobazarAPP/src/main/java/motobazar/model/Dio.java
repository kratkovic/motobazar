/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

    @Entity
    public class Dio extends Entitet{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sifra")
    private int sifra;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "proizvodac")
    private String proizvodac;

    @Column(name = "cijena")
    private BigDecimal cijena;

    @Column(name = "kolicina")
    private int kolicina;

    @Column(name = "opis")
    private String opis;

    @Column(name = "slika_url")
    private String slika_url;

    @ManyToOne
    @JoinColumn(name = "korisnik_sifra")
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name = "kategorija_sifra")
    private Kategorija kategorija;

     public Dio() {
        super();
    }

     
    public Dio(String naziv, String proizvodac, BigDecimal cijena, int kolicina, String opis, String slika_url, Korisnik korisnik, Kategorija kategorija) {
        this.naziv = naziv;
        this.proizvodac = proizvodac;
        this.cijena = cijena;
        this.kolicina = kolicina;
        this.opis = opis;
        this.slika_url = slika_url;
        this.korisnik = korisnik;
        this.kategorija = kategorija;
    }

    @Override
    public int getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getProizvodac() {
        return proizvodac;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public String getSlika_url() {
        return slika_url;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setProizvodac(String proizvodac) {
        this.proizvodac = proizvodac;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setSlika_url(String slika_url) {
        this.slika_url = slika_url;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
}

    

