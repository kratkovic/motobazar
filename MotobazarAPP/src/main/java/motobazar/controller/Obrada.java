/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.controller;

import java.util.List;
import motobazar.model.Entitet;
import motobazar.util.HibernateUtil;
import motobazar.util.MotobazarException;
import org.hibernate.Session;

public abstract class Obrada<T extends Entitet> {

    protected T entitet;
    protected Session session;

    public abstract List<T> read();

    protected abstract void kontrolaUnos() throws MotobazarException;

    protected abstract void kontrolaPromjena() throws MotobazarException;

    protected abstract void kontrolaBrisanje() throws MotobazarException;

    public Obrada() {
        this.session = HibernateUtil.getSession();

    }

    public void create() throws MotobazarException {
        if (entitet == null) {
            throw new MotobazarException("Entitet je null");
        }
        kontrolaUnos();
        persist();
    }

    public void update() throws MotobazarException{
        kontrolaPromjena();
        persist();
    }
    
    public void delete()throws MotobazarException{
        kontrolaBrisanje();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
        
    }
    private void persist(){
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }
     public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
}