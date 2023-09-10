/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.controller;

import java.util.List;
import motobazar.model.Kategorija;
import motobazar.util.MotobazarException;


public class ObradaKategorija extends Obrada<Kategorija>  {

    @Override
    public List<Kategorija> read() {
        
         return session.createQuery("from Kategorija", Kategorija.class).list();
    }

    @Override
    protected void kontrolaUnos() throws MotobazarException {
      
    }

    @Override
    protected void kontrolaPromjena() throws MotobazarException {
      
    }

    @Override
    protected void kontrolaBrisanje() throws MotobazarException {
       
    }
    
}
