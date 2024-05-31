/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.controller;

import java.util.List;
import motobazar.model.Kategorija;
import motobazar.util.MotobazarException;
import org.hibernate.Transaction;

public class ObradaKategorija extends Obrada<Kategorija> {

    @Override
    public List<Kategorija> read() {
        return session.createQuery("from Kategorija", Kategorija.class).list();
    }

    @Override
    protected void kontrolaUnos() throws MotobazarException {
        kontrolaNaziv();
        kontrolaOpis();
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
            throw new MotobazarException("Naziv kategorije ne smije biti broj");
        }

    }

    private void kontrolaNazivMinimalnaDuzina() throws MotobazarException {
        if (entitet.getNaziv().trim().length() < 3) {
            throw new MotobazarException("Naziv kategorije mora imati minimalno 3 znaka");
        }
    }

    private void kontrolaNazivMaksimalnaDuzina() throws MotobazarException {
        if (entitet.getNaziv().trim().length() > 50) {
            throw new MotobazarException("Naziv kategorije može imati minimalno 50 znakova");
        }

    }

    private void kontrolaNaziv() throws MotobazarException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
    }

    private void kontrolaOpis() throws MotobazarException {
        kontrolaOpisNull();
        kontrolaOpisMinimalnaDuzina();
        kontrolaOpisMaksimalnaDuzina();
    }

    private void kontrolaOpisNull() throws MotobazarException {
        if (entitet.getOpis() == null) {
            throw new MotobazarException("Opis mora biti postavljen");
        }
    }

    private void kontrolaOpisMinimalnaDuzina() throws MotobazarException {
        if (entitet.getOpis().trim().length() < 10) {
            throw new MotobazarException("Opis mora imati minimalno 10 znakova");
        }
    }

    private void kontrolaOpisMaksimalnaDuzina() throws MotobazarException {
        if (entitet.getOpis().trim().length() > 500) {
            throw new MotobazarException("Opis može imati maksimalno 500 znakova");
        }
    }

    private void kontrolaNazivDupliUBazi() throws MotobazarException {
        List<Kategorija> kategorije = null;
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            kategorije = session.createQuery("from Kategorija k "
                    + "where k.naziv = :naziv", Kategorija.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new MotobazarException("Došlo je do pogreške pri dohvatu kategorije iz baze");
        }

        if (kategorije != null && !kategorije.isEmpty()) {
            throw new MotobazarException("Kategorija s istim nazivom već postoji u bazi");
        }
    }
}
