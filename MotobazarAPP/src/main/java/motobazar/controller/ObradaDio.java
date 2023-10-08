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
        kontrolaNaziv();
        kontrolaKolicina();
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

    private void kontrolaNazivNull() throws MotobazarException {
        if (entitet.getNaziv() == null) {
            throw new MotobazarException("Naziv mora biti postavljen");
        }

    }

    private void kontrolaNazivNijeBroj() throws MotobazarException {
        boolean broj = false;
        try {
            Double.valueOf(entitet.getNaziv());
            broj = true;
        } catch (Exception e) {
        }

        if (broj) {
            throw new MotobazarException("Naziv dio za motor ne smije biti broj");
        }
    }

    private void kontrolaNazivMinimalnaDuzina() throws MotobazarException {
        if (entitet.getNaziv().trim().length() < 3) {
            throw new MotobazarException("Naziv dio za motor mora imati minimalno 3 znaka");
    }
        
    }
    
    private void kontrolaNazivMaksimalnaDuzina() {

    }

    private void kontrolaNaziv() throws MotobazarException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
    }

    private void kontrolaKolicina() {
        
    }

    private void kontrolaNazivDupliUBazi() {
       
    }

}
