package motobazar.controller;

import java.util.List;
import motobazar.model.Dio;
import motobazar.util.MotobazarException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        kontrolaPovezanostiSKategorijom();
    }

    private void kontrolaPovezanostiSKategorijom() throws MotobazarException {
        if (provjeriPovezanostSKategorijom(entitet)) {
            throw new MotobazarException("Nije moguće obrisati dio koji je povezan s kategorijom");
        }
    }

    private boolean provjeriPovezanostSKategorijom(Dio dio) {
        return dio.getKategorija() != null;
    }

    private void kontrolaNazivNull() throws MotobazarException {
        if (entitet.getNaziv() == null) {
            throw new MotobazarException("Naziv mora biti postavljen");
        }
    }

    private void kontrolaNazivNijeBroj() throws MotobazarException {
        try {
            Double.valueOf(entitet.getNaziv());
            throw new MotobazarException("Naziv dio za motor ne smije biti broj");
        } catch (NumberFormatException e) {
            // Očekivano ponašanje ako nije broj
        }
    }

    private void kontrolaNazivMinimalnaDuzina() throws MotobazarException {
        if (entitet.getNaziv().trim().length() < 3) {
            throw new MotobazarException("Naziv dio za motor mora imati minimalno 3 znaka");
        }
    }

    private void kontrolaNazivMaksimalnaDuzina() throws MotobazarException {
        if (entitet.getNaziv().trim().length() > 50) {
            throw new MotobazarException("Naziv dio za motor može imati maksimalno 50 znakova");
        }
    }

    private void kontrolaNaziv() throws MotobazarException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
    }

    private void kontrolaKolicina() throws MotobazarException {
        int kolicina = entitet.getKolicina();

        if (kolicina < 1 || kolicina > 100) {
            throw new MotobazarException("Količina mora biti barem 1 i ne može biti veća od 100");
        }
    }

    private void kontrolaNazivDupliUBazi() throws MotobazarException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            List<Dio> dijelovi = session.createQuery("from Dio d where d.naziv = :naziv", Dio.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();

            transaction.commit();

            if (!dijelovi.isEmpty()) {
                throw new MotobazarException("Dio s istim nazivom već postoji u bazi");
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new MotobazarException("Došlo je do pogreške pri dohvatu dijela iz baze", e);

        } finally {
            session.close();
        }
    }
}
