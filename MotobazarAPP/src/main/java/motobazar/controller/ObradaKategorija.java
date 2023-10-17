/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.controller;

import java.util.List;
import motobazar.model.Kategorija;
import motobazar.util.MotobazarException;

public class ObradaKategorija extends Obrada<Kategorija> {

    @Override
    public List<Kategorija> read() {
        return session.createQuery("from Kategorija", Kategorija.class).list();
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

    private void kontrolaNazivNull() throws MotobazarException {
        if (entitet.getNaziv() == null) {
            throw new MotobazarException("Naziv mora biti postavljen");
        }
    }

    private void kontrolaNazivNijeBroj()throws MotobazarException{
       boolean broj = false;
        try {
            Double.valueOf(entitet.getNaziv());
            broj = true;
        } catch (Exception e) {
        }

        if (broj) {
            throw new MotobazarException("Naziv kategorije ne smije biti broj");
        }

    }

    private void kontrolaNazivMinimalnaDuzina() {

    }

    private void kontrolaNazivMaksimalnaDuzina() {

    }

}
