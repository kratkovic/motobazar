/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.controller;

import java.util.List;
import motobazar.model.Dio;
import motobazar.util.MotobazarException;



public class ObradaDio extends Obrada<Dio> {

    @Override
    public List<Dio> read() {
       
        return session.createQuery("from Dio", Dio.class).list();
       
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