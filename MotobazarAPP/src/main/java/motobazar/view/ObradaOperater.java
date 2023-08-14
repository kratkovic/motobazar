/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.view;

import java.util.List;
import motobazar.controller.Obrada;
import motobazar.model.Operater;


public class ObradaOperater extends Obrada<Operater>{
    
    @Override
    public List<Operater> read(){
        return session.createQuery("from Operater", Operater.class).list();
    } 
   
}