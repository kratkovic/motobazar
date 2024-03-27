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
        // Možete implementirati dodatnu logiku brisanja ako je potrebno
    }

    private void kontrolaOcjena() throws MotobazarException {
        int ocjenaVrijednost = entitet.getOcjena();

        if (ocjenaVrijednost < 1 || ocjenaVrijednost > 5) {
            throw new MotobazarException("Ocjena mora biti u rasponu od 1 do 5.");
        }
    }
}
