/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.model;

import jakarta.persistence.Entity;

@Entity
public class Korisnik extends Entitet {

    private String ime;
    private String prezime;
    private String adresa;
    private String email;

    public Korisnik() {
        super();
    }

    public Korisnik(String ime, String prezime, String adresa, String email, int sifra) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    

}
