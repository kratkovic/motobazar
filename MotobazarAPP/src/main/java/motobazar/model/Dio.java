/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Dio extends Entitet{
    
    private String naziv;
    private String proizvodac;
    private BigDecimal cijena;
    private String kolicina;
    private String opis;
    private Korisnik korisnik;
    private Kategorija kategorija;

    public Dio() {
        super();
    }

    public Dio(String naziv, String proizvodac, BigDecimal cijena, String kolicina, String opis, Korisnik korisnik, Kategorija kategorija, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.proizvodac = proizvodac;
        this.cijena = cijena;
        this.kolicina = kolicina;
        this.opis = opis;
        this.korisnik = korisnik;
        this.kategorija = kategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProizvodac() {
        return proizvodac;
    }

    public void setProizvodac(String proizvodac) {
        this.proizvodac = proizvodac;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public String getKolicina() {
        return kolicina;
    }

    public void setKolicina(String kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
    
    
    
}
