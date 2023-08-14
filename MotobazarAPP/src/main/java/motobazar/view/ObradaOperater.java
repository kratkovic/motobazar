/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.view;

import java.util.List;
import motobazar.controller.Obrada;
import motobazar.model.Operater;
import motobazar.util.MotobazarException;


public class ObradaOperater extends Obrada<Operater>{
    
    @Override
    public List<Operater> read(){
        return session.createQuery("from Operater", Operater.class).list();
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