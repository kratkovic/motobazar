package motobazar.controller;

import java.util.List;
import motobazar.model.Ocjena;
import motobazar.util.MotobazarException;

public class ObradaOcjena extends Obrada<Ocjena> {

    @Override
    public List<Ocjena> read() {
        return session.createQuery("from Ocjena", Ocjena.class).list();
    }

    @Override
    protected void kontrolaUnos() throws MotobazarException {
        kontrolaOcjena();
    }

    @Override
    protected void kontrolaPromjena() throws MotobazarException {
        kontrolaOcjena();
    }

    @Override
    protected void kontrolaBrisanje() throws MotobazarException {
         // Provjera da li je ocjena povezana s drugim entitetima
        if (entitet.getDio() != null || entitet.getKorisnik() != null) {
            throw new MotobazarException("Ocjena je povezana s drugim entitetima i ne može biti obrisana.");
        }
    }

    private void kontrolaOcjena() throws MotobazarException {
        int ocjenaVrijednost = entitet.getOcjena();

        if (ocjenaVrijednost < 1 || ocjenaVrijednost > 5) {
            throw new MotobazarException("Ocjena mora biti u rasponu od 1 do 5.");
        }
    }
}
