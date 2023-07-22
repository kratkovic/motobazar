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
    
    
    
}
