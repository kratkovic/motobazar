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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


@Entity
public class Poruka extends Entitet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sifra")
    private int sifra;

    @ManyToOne
    @JoinColumn(name = "posiljatelj_sifra")
    private Korisnik posiljatelj;

    @ManyToOne
    @JoinColumn(name = "primatelj_sifra")
    private Korisnik primatelj;

    @Column(name = "sadrzaj")
    private String sadrzaj;

    @Column(name = "datum_vrijeme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumVrijeme;

    public Poruka() {
        super();
    }

    
    public Poruka(Korisnik posiljatelj, Korisnik primatelj, String sadrzaj, Date datumVrijeme) {
        this.posiljatelj = posiljatelj;
        this.primatelj = primatelj;
        this.sadrzaj = sadrzaj;
        this.datumVrijeme = datumVrijeme;
    }

    @Override
    public int getSifra() {
        return sifra;
    }

    public Korisnik getPosiljatelj() {
        return posiljatelj;
    }

    public Korisnik getPrimatelj() {
        return primatelj;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public Date getDatumVrijeme() {
        return datumVrijeme;
    }

    public void setPosiljatelj(Korisnik posiljatelj) {
        this.posiljatelj = posiljatelj;
    }

    public void setPrimatelj(Korisnik primatelj) {
        this.primatelj = primatelj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public void setDatumVrijeme(Date datumVrijeme) {
        this.datumVrijeme = datumVrijeme;
    }
    
}


