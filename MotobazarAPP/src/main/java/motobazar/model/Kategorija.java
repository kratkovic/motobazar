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

@Entity
public class Kategorija extends Entitet {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sifra")
    private int sifra;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "opis")
    private String opis;


    public Kategorija() {
        super();
    }

    public Kategorija(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
    }

   
    @Override
    public int getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    // Set metode
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}

    
