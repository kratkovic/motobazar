/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.view;

import jakarta.persistence.NoResultException;
import java.util.List;
import motobazar.controller.Obrada;
import motobazar.model.Operater;
import motobazar.util.MotobazarException;
import org.mindrot.jbcrypt.BCrypt;


public class ObradaOperater extends Obrada<Operater>{
    
    @Override
    public List<Operater> read(){
        return session.createQuery("from Operater", Operater.class).list();
    } 

     public void unosAdminOperatera() {

        Operater o = new Operater();
        o.setIme("Kristijan");
        o.setPrezime("Ratković");
        o.setEmail("ratkovic.kristijan@gmail.com");
        o.setLozinka(BCrypt.hashpw("Motobazar33",
                BCrypt.gensalt()).toCharArray());

        entitet = o;
        try {
            create();
        } catch (MotobazarException ex) {

        }
    }
         public Operater autoriziraj(String email, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater o where o.email=:email",
                    Operater.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka),
                new String(o.getLozinka()))) {
            return o;
        }

        return null;
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