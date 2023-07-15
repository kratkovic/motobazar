/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.model;

import jakarta.persistence.Entity;


@Entity
public class Korisnik extends Entitet{
    
    private String ime;
    private String prezime;
    private String adresa;
    private String email;
}
