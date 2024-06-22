package motobazar.controller;

import java.util.List;
import motobazar.model.Korisnik;
import motobazar.util.MotobazarException;

public class ObradaKorisnik extends Obrada<Korisnik> {

    @Override
    public List<Korisnik> read() {
        return session.createQuery("from Korisnik", Korisnik.class).list();
    }

    @Override
    protected void kontrolaUnos() throws MotobazarException {
        kontrolaIspravnostiPodataka();
    }

    @Override
    protected void kontrolaPromjena() throws MotobazarException {
        kontrolaIspravnostiPodataka();
    }

    @Override
    protected void kontrolaBrisanje() throws MotobazarException {
       
    }

    public void obrisiKorisnika(int sifra) throws MotobazarException {
        Korisnik korisnik = session.find(Korisnik.class, sifra);
        if (korisnik == null) {
            throw new MotobazarException("Korisnik s tom šifrom ne postoji.");
        }

        try {
            session.beginTransaction();
            session.remove(korisnik);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new MotobazarException("Greška pri brisanju korisnika: " + e.getMessage());
        }
    }

    private void kontrolaIspravnostiPodataka() throws MotobazarException {
        provjeriIme();
        provjeriPrezime();
        provjeriAdresu();
        provjeriEmail();
        provjeriLozinku();
    }

    
    private void provjeriIme() throws MotobazarException {
        if (entitet.getIme() == null || entitet.getIme().isEmpty()) {
            throw new MotobazarException("Ime korisnika mora biti unešeno");
        }
    }

    private void provjeriPrezime() throws MotobazarException {
        if (entitet.getPrezime() == null || entitet.getPrezime().isEmpty()) {
            throw new MotobazarException("Prezime korisnika mora biti unešeno");
        }
    }

    private void provjeriAdresu() throws MotobazarException {
        if (entitet.getAdresa() == null || entitet.getAdresa().isEmpty()) {
            throw new MotobazarException("Adresa korisnika mora biti unešena");
        }
    }

    private void provjeriEmail() throws MotobazarException {
        if (entitet.getEmail() == null || entitet.getEmail().isEmpty()) {
            throw new MotobazarException("Email korisnika mora biti unešen");
        }
    }

    private void provjeriLozinku() throws MotobazarException {
        if (entitet.getLozinka() == null || entitet.getLozinka().isEmpty()) {
            throw new MotobazarException("Lozinka korisnika mora biti unešena");
        }
    }
}