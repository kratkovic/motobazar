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

   @Entity
   public class Ocjena extends Entitet{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sifra")
    private int sifra;

    @ManyToOne
    @JoinColumn(name = "dio_sifra")
    private Dio dio;

    @ManyToOne
    @JoinColumn(name = "korisnik_sifra")
    private Korisnik korisnik;

    @Column(name = "ocjena")
    private int ocjena;


    public Ocjena() {
        super();
    }

    public Ocjena(Dio dio, Korisnik korisnik, int ocjena) {
        this.dio = dio;
        this.korisnik = korisnik;
        this.ocjena = ocjena;
    }


    @Override
    public int getSifra() {
        return sifra;
    }

    public Dio getDio() {
        return dio;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setDio(Dio dio) {
        this.dio = dio;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }
}

    

