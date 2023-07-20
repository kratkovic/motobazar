/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.model;

import jakarta.persistence.Entity;

@Entity
public class Kategorija extends Entitet {

    private String naziv;
    private String opis;

    public Kategorija() {
        super();
    }

    public Kategorija(String naziv, String opis, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.opis = opis;

    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
