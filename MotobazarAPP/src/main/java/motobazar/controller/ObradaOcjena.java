/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.controller;

import java.util.List;
import motobazar.model.Ocjena;
import motobazar.util.MotobazarException;

public class ObradaOcjena extends Obrada<Ocjena>{

    @Override
    public List<Ocjena> read() {
       return null;
    }

    @Override
    protected void kontrolaUnos() throws MotobazarException {
     
    }

    @Override
    protected void kontrolaPromjena() throws MotobazarException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
    }

    @Override
    protected void kontrolaBrisanje() throws MotobazarException {
        
    }

    private void kontrolaNazivNull() {
        
    }

    private void kontrolaNazivNijeBroj() {
       
    }

    private void kontrolaNazivMinimalnaDuzina() {
        
    }

    private void kontrolaNazivMaksimalnaDuzina() {
      
    }
    
}
